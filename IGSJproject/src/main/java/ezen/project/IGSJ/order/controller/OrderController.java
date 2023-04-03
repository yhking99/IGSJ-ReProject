package ezen.project.IGSJ.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.service.OrderService;

@Controller("orderController")
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired(required = false)
	private OrderService orderService;

	// 주문 페이지 불러오기
	@RequestMapping(value="/orderPage/{userId}", method=RequestMethod.GET)
	public OrderDTO orderPage(@PathVariable("userId") String userId) throws Exception{
		
		logger.info("주문 페이지 불러오기 orderPage - Controller");
		OrderDTO orderDTO = orderService.orderPage(userId);
		
		return orderDTO;
	}

	
	/*
	 * // 주문서 작성 페이지(OrderPage)
	 * 
	 * @RequestMapping(value = "/orderPage", method = RequestMethod.GET) public
	 * String orderWritePage(HttpServletRequest req, String userId, MemberAddressDTO
	 * memberAddressDTO, CartDTO cartDTO, Model model) throws Exception {
	 * 
	 * logger.info("주문서 작성 페이지 orderWritePage - OrderController");
	 * 
	 * 
	 * MemberDTO memberLoginSession = (MemberDTO)
	 * session.getAttribute("memberInfo");
	 * 
	 * if (memberLoginSession != null) { // 해당 아이디의 회원이름, 번호, 주소를 가져온다 // 해당 아이디의
	 * 장바구니에 담긴 제품의 정보를 가져온다 MemberAddressDTO memberAddress =
	 * orderService.memberAddress(memberLoginSession.getUserId());
	 * 
	 * cartDTO.setUserId(memberLoginSession.getUserId());
	 * 
	 * List<CartDTO> cartList = cartService.cartList(cartDTO);
	 * 
	 * model.addAttribute("cartList", cartList);
	 * 
	 * model.addAttribute("memberAddress", memberAddress);
	 * 
	 * return "/orderPage"; } else { return "/orderPage"; } }
	 */

	
	// 주문 내역 조회(OrderList)
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void orderList(HttpServletRequest req, OrderDTO orderDTO, Model model) throws Exception {

		// orderDTO에서 아이디에 해당하는 주문 목록(list)을 가져온다

		logger.info("주문 내역 조회 orderList - orderController");

		HttpSession session = req.getSession();

		MemberDTO memberLoginSession = (MemberDTO) session.getAttribute("MemberInfo");

		orderDTO.setUserId(memberLoginSession.getUserId());

		List<OrderDTO> orderList = orderService.orderList(orderDTO);

		model.addAttribute("orderList", orderList);

	}

	/*
	 * // 주문 상세 내역 조회
	 * 
	 * @RequestMapping(value="/orderDetail", method = RequestMethod.GET) public
	 * String orderDetail( HttpServletRequest req, OrderDTO orderDTO ) throws
	 * Exception{
	 * 
	 * logger.info("주문 상세 내역 조회 orderDetail - orderController");
	 * 
	 * HttpSession session = req.getSession();
	 * 
	 * MemberDTO memberLoginSession = (MemberDTO)
	 * session.getAttribute("memberInfo");
	 * 
	 * orderDTO.setUserId(memberLoginSession.getUserId());
	 * 
	 * 
	 * 
	 * }
	 */
}
