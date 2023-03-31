package ezen.project.IGSJ.order.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.order.service.OrderServiceImpl;

import ezen.project.IGSJ.order.dao.OrderDAO;
import ezen.project.IGSJ.order.domain.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService{

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderDAO orderDAO;

	//주문 정보
	@Override
	public void orderInfo(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문 정보");
		
		orderDAO.orderInfo(orderDTO);
		
	}
	
	
}
