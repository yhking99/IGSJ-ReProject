package ezen.project.IGSJ.order.service;

import org.mybatis.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.order.dao.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService{

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderDAO orderDAO;
	
	
}
