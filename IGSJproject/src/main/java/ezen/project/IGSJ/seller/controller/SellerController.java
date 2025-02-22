package ezen.project.IGSJ.seller.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

import ezen.project.IGSJ.category.domain.CategoryDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;
import ezen.project.IGSJ.seller.service.SellerService;
import ezen.project.IGSJ.utils.AwsS3;
import ezen.project.IGSJ.utils.pagination.PageIngredient;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/seller/*")
public class SellerController {

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Inject
	private SellerService sellerService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 메인페이지
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public void getMain() throws Exception {
	}

	// 상품 등록 페이지 접속
	@RequestMapping(value = "/productRegister", method = RequestMethod.GET)
	public void sellerRegisterPage() throws Exception {
		
		logger.info("판매자 상품 등록 페이지 접속");
	}

	// 카테고리 불러오기 ajax
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public JSONArray getRegister() throws Exception {

		List<CategoryDTO> category = null;
		category = sellerService.getCategory();
		/*model.addAttribute("category", JSONArray.fromObject(category));*/

		return JSONArray.fromObject(category);
	}

	// aws s3 상품 업로드
	@RequestMapping(value = "/productRegister", method = RequestMethod.POST)
	public String postRegister(ProductDTO product, ProductFileDTO productFile, @RequestParam("product_img") MultipartFile file,
			HttpServletRequest request) throws Exception {

		AwsS3 awsS3 = AwsS3.getInstance();
		String s3ObjectUrl = null;

		try {
			// Upload file to S3 bucket
			String fileName = file.getOriginalFilename();
			InputStream is = file.getInputStream();

			s3ObjectUrl = awsS3.upload(is, fileName, file.getContentType(), file.getSize());

			// Set the file properties
			String rs = RandomStringUtils.randomAlphanumeric(20);
			product.setPno(rs);
			productFile.setPno(rs);
			product.setUserId("1111");
			productFile.setOriginalFileName(fileName);
			productFile.setStoredFileRootName(s3ObjectUrl);

			// Call the sellerService to save the product and file information
			sellerService.postRegister(product, productFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/seller/productlist?pageNum=1";
	}

	// --------------------------------------------------------------------------
	// ck 에디터에서 파일 업로드
	// --------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value = "/register/ckUpload", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile) throws IOException {

		// Json 객체 생성
		JsonObject json = new JsonObject();
		// Json 객체를 출력하기 위해 PrintWriter 생성
		PrintWriter printWriter = null;
		OutputStream out = null;
		// 파일을 가져오기 위해 MultipartHttpServletRequest 의 getFile 메서드 사용
		MultipartFile file = multiFile.getFile("upload");
		
		AwsS3 awsS3 = AwsS3.getInstance();
		String uploadPath = null;
		// 파일이 비어있지 않고(비어 있다면 null 반환)
		if (file != null) {
			// 파일 사이즈가 0보다 크고, 파일이름이 공백이 아닐때
			if (file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				if (file.getContentType().toLowerCase().startsWith("image/")) {

					try {
						// 파일 이름 설정
						String fileName = file.getOriginalFilename();
						InputStream is = file.getInputStream();
						// 바이트 타입설정
						byte[] bytes;
						// 파일을 바이트 타입으로 변경
						bytes = file.getBytes();
						// 파일이 실제로 저장되는 경로
						uploadPath = awsS3.upload(is, fileName, file.getContentType(), file.getSize());
						// 저장되는 파일에 경로 설정
						File uploadFile = new File(uploadPath);
						if (!uploadFile.exists()) {
							uploadFile.mkdirs();
						}

						// 클라이언트에 이벤트 추가
						printWriter = response.getWriter();
						response.setContentType("text/html");

						// 파일이 연결되는 Url 주소 설정
						String fileUrl =  uploadPath;

						// 생성된 jason 객체를 이용해 파일 업로드 + 이름 + 주소를 CkEditor에 전송
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						printWriter.println(json);

					} catch (IOException e) {
						e.printStackTrace();

					} finally {
						if (out != null) {
							out.close();
						}
						if (printWriter != null) {
							printWriter.close();
						}
					}
				}
			}
		}
		return null;
	}

	// 전체 상품 목록 불러오기
	@RequestMapping(value = "/seller/productlist", method = RequestMethod.GET)
	public void getProductList(@RequestParam("pageNum") int pageNum,
			@RequestParam(value = "searchType", required = false, defaultValue = "product_name") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword, PageIngredient page, Model model) throws Exception {

		// 파라미터 순서 int contentNum , int maxPageNum, int selectContent
		page = new PageIngredient(5, 5, 5);

		page.setPageNum(pageNum);
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		page.setSearchTypeAndKeyword(searchType, keyword);

		// 게시글 총 갯수를 구한다. 단 검색타입과 키워드에 맞춘 결과에 대한 총 갯수를 출력해야한다.
		page.setTotalContent(sellerService.searchProduct(searchType, keyword));

		List<ProductDTO> sellerProductList = null;
		sellerProductList = sellerService.getProductList(page.getSelectContent(), page.getContentNum(), searchType, keyword);
		model.addAttribute("sellerProductList", sellerProductList);
		model.addAttribute("page", page);

		// 현재 페이지가 몇페이지인지 쉽게 구분하기위한 구분자를 넘겨주자
		model.addAttribute("selectedPageNum", pageNum);

	}

	// 판매자 상품 조회
	@RequestMapping(value = "/seller/productview", method = RequestMethod.GET)
	public void methodName() throws Exception {

	}
}