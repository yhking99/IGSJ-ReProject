package ezen.project.IGSJ.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.product.service.ProductService;

@Controller("ProductController")
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// 카테고리 넘버에 따른 상품 추출
	@GetMapping("/items/{num}")
	@ResponseBody
	public List<ProductDTO> getProductList(@PathVariable int num) throws Exception {
		System.out.println(num);
		List<ProductDTO> productList = productService.getProductList(num);
		return productList;
	} // getCategoryInfos

	// 검색어에 따른 상품 추출
	@GetMapping("/search")
	@ResponseBody
	public List<ProductDTO> getProducts(@RequestParam String type) throws Exception {
		System.out.println(type);
		return productService.getProducts(type);
	} // getProducts

	// 선택된 상품에 대한 정보
	@GetMapping("/detail")
	@ResponseBody
	public ProductDTO getProductInfo(@RequestParam String pno) throws Exception {
		System.out.println(pno);
		return productService.getProductInfo(pno);
	} // getProducts

	// 모든 상품에 대한 정보(테스터) => 주문량 상위 10종목으로 수정하기
	@GetMapping("/all")
	@ResponseBody
	public List<ProductDTO> allProductInfo() throws Exception {
		return productService.allProductInfo();
	} // allProductInfo

	// 신상품 10개 추출
	@GetMapping("/brandnew")
	@ResponseBody
	public List<ProductDTO> newProductInfo() throws Exception {
		return productService.newProductInfo();
	} // newProductInfo
} // public class ProductController