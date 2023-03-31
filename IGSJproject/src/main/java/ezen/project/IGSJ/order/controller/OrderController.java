package ezen.project.IGSJ.order.controller;

import org.mybatis.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.service.OrderService;

@Controller("orderController")
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderDTO orderDTO;
	@Autowired
	private OrderService orderService;
	
	//주문서 작성 페이지
	
}
