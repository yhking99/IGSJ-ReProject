package ezen.project.IGSJ.admin.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.admin.service.AdminService;
import ezen.project.IGSJ.category.domain.CategoryDTO;
import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;
import ezen.project.IGSJ.seller.service.SellerService;
import ezen.project.IGSJ.utils.UploadFileUtils;
import ezen.project.IGSJ.utils.pagination.PageIngredient;
import net.sf.json.JSONArray;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@Autowired
	private SellerService sellerService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 관리자 페이지 입장
	@RequestMapping(value = "/admin/mainpage", method = RequestMethod.GET)
	public void adminMainPage() throws Exception {

		logger.info("관리자 페이지 입장");

	}

	// 전체 회원 불러오기
	@RequestMapping(value = "/admin/memberlist", method = RequestMethod.GET)
	public void getAllUsers(@RequestParam("pageNum") int pageNum,
			@RequestParam(value = "searchType", required = false, defaultValue = "userId") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword, PageIngredient page, Model model) throws Exception {

		logger.info("관리자 페이지 - 회원 목록 출력 getAllUsers - controller");

		logger.info("관리자 페이지 - 회원 목록 출력 검색타입: {} , 검색어 : {} ", searchType, keyword);

		// 파라미터 순서 int contentNum , int maxPageNum, int selectContent
		page = new PageIngredient(10, 10, 10);

		page.setPageNum(pageNum);
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		page.setSearchTypeAndKeyword(searchType, keyword);

		// 게시글 총 갯수를 구한다. 단 검색타입과 키워드에 맞춘 결과에 대한 총 갯수를 출력해야한다.
		page.setTotalContent(adminService.searchMember(searchType, keyword));

		List<MemberDTO> adminMemberList = null;
		adminMemberList = adminService.getAllUsers(page.getSelectContent(), page.getContentNum(), searchType, keyword);
		model.addAttribute("adminMemberList", adminMemberList);
		model.addAttribute("page", page);

		// 현재 페이지가 몇페이지인지 쉽게 구분하기위한 구분자를 넘겨주자
		model.addAttribute("selectedPageNum", pageNum);

	}

	// 관리자 회원 정보 수정 페이지 진입
	@RequestMapping(value = "/admin/membermodifypage", method = RequestMethod.GET)
	public String adminMemberModifyPage(@RequestParam("userId") String userId, MemberDTO memberDTO, MemberAddressDTO memberAddressDTO, Model model)
			throws Exception {

		logger.info("관리자 회원 정보 수정 페이지 접속");

		memberDTO = adminService.adminSelectMember(userId);

		memberAddressDTO = adminService.adminSelectAddress(userId);

		model.addAttribute("userInfo", memberDTO);
		model.addAttribute("userAddressInfo", memberAddressDTO);

		return "/admin/membermodify";
	}

	// 관리자 회원 정보 수정 실행
	@RequestMapping(value = "/admin/membermodify", method = RequestMethod.POST)
	public String adminMemberModify(MemberDTO memberDTO, MemberAddressDTO memberAddressDTO, HttpSession session) throws Exception {

		logger.info("관리자 회원 정보 수정 시작");

		adminService.adminMemberModify(memberDTO, memberAddressDTO);

		return "redirect:/admin/memberlist?pageNum=1";
	}

	// 관리자 회원 삭제 ajax
	@ResponseBody
	@RequestMapping(value = "/admin/removeMember", method = RequestMethod.POST)
	public boolean adminRemoveMember(@RequestParam("userId") String userId) throws Exception {

		logger.info("관리자 회원 삭제 시작 controller");

		adminService.adminRemoveMember(userId);

		return true;
	}

	// 관리자 인증번호 생성하기
	@ResponseBody
	@RequestMapping(value = "/admin/removeMember", method = RequestMethod.GET)
	public String generateAdminAuthPwd(@RequestParam("tempAdminPwd") String tempAdminPwd) throws Exception {

		tempAdminPwd = RandomStringUtils.randomAlphanumeric(20);

		System.out.println("관리자 인증번호 생성 완료 : " + tempAdminPwd);

		return tempAdminPwd;

	}

	// 전체 상품 목록 불러오기
	@RequestMapping(value = "/admin/productlist", method = RequestMethod.GET)
	public void getProductList(@RequestParam("pageNum") int pageNum,
			@RequestParam(value = "searchType", required = false, defaultValue = "product_name") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword, PageIngredient page, Model model) throws Exception {

		logger.info("관리자 페이지 - 상품 목록 출력 getProductList - controller");

		logger.info("관리자 페이지 - 상품 목록 출력 검색타입: {} , 검색어 : {} ", searchType, keyword);

		// 파라미터 순서 int contentNum , int maxPageNum, int selectContent
		page = new PageIngredient(5, 5, 5);

		page.setPageNum(pageNum);
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		page.setSearchTypeAndKeyword(searchType, keyword);

		// 게시글 총 갯수를 구한다. 단 검색타입과 키워드에 맞춘 결과에 대한 총 갯수를 출력해야한다.
		page.setTotalContent(adminService.searchProduct(searchType, keyword));

		List<ProductDTO> adminProductList = null;
		adminProductList = adminService.getProductList(page.getSelectContent(), page.getContentNum(), searchType, keyword);
		model.addAttribute("adminProductList", adminProductList);
		model.addAttribute("page", page);

		// 현재 페이지가 몇페이지인지 쉽게 구분하기위한 구분자를 넘겨주자
		model.addAttribute("selectedPageNum", pageNum);

	}

	// 관리자 상품 정보 조회
	@RequestMapping(value = "/admin/productDetail", method = RequestMethod.GET)
	public String adminProductViewPage(@RequestParam("pno") String pno, ProductDTO productDTO, Model model) throws Exception {

		logger.info("관리자 회원 정보 수정 페이지 접속");

		productDTO = adminService.adminProductViewPage(pno);

		model.addAttribute("productInfo", productDTO);

		return "/admin/productdetail";
	}

	// 관리자 상품 정보 수정 페이지 진입
	@RequestMapping(value = "/admin/productmodify", method = RequestMethod.GET)
	public String adminProductModifyPage(@RequestParam("pno") String pno, ProductDTO productDTO, Model model) throws Exception {

		logger.info("관리자 상품 정보 수정 페이지 접속");

		List<CategoryDTO> category = null;

		category = sellerService.getCategory();

		model.addAttribute("category", JSONArray.fromObject(category));

		productDTO = adminService.adminProductViewPage(pno);

		model.addAttribute("productInfo", productDTO);

		return "/admin/productmodify";
	}

	// 관리자 상품 정보 수정
	@RequestMapping(value = "/admin/productmodify", method = RequestMethod.POST)
	public String adminProductModify(ProductDTO productDTO, ProductFileDTO productFile,
			MultipartFile file, Model model, HttpServletRequest req) throws Exception {

		logger.info("관리자 상품 정보 수정 시작 controller");

		// 새로운 파일이 등록되었는지 확인
		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			// 기존 파일을 삭제
			new File(uploadPath + req.getParameter("originalFileName")).delete();
			new File(uploadPath + req.getParameter("storedFileRootName")).delete();
			new File(uploadPath + req.getParameter("storedThumbNailName")).delete();

			// 새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			// DB에 저장될 파일 경로, 이 경로는 나중에 img태그를 이용하여 클라이언트한테 이미지를 보여줄 때 중요하게 사용이 된다.
			String storedFileName = File.separator + "imgUpload" + ymdPath + File.separator + fileName;
			String storedThumbNail = File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName;

			productFile.setOriginalFileName(file.getOriginalFilename());
			productFile.setStoredFileRootName(storedFileName);
			productFile.setStoredThumbNailName(storedThumbNail);

		} else { 
			// 새로운 파일이 등록되지 않았다면
			// 기존 이미지를 그대로 사용
			productFile.setOriginalFileName(req.getParameter("originalFileName"));
			productFile.setStoredFileRootName(req.getParameter("storedFileRootName"));
			productFile.setStoredThumbNailName(req.getParameter("storedThumbNailName"));

		}
		logger.info("제품 이미지까지 수정 완료");

		adminService.adminProductModify(productDTO, productFile);

		return "redirect:/admin/productDetail?pno=" + productDTO.getPno();
	}

}
