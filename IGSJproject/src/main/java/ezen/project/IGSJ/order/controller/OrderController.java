package ezen.project.IGSJ.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.service.OrderService;

@Controller("orderController")
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/order")
public class OrderController {

	@Autowired(required = false)
	private OrderDTO orderDTO;
	@Autowired(required = false)
	private OrderService orderService;
	
	//주문서 작성 페이지
	
}
