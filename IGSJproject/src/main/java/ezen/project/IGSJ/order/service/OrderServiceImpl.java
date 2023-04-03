package ezen.project.IGSJ.order.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.order.service.OrderServiceImpl;
import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.order.dao.OrderDAO;
import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDAO;
	
	// 주문 페이지 불러오기
	@Override
	public OrderDTO orderPage(String userId) throws Exception {
		return orderDAO.orderPage(userId);
		
	}
	
	
	
	// 주문 등록
	@Override
	public void orderWrite(OrderDTO orderDTO) throws Exception {

		logger.info("주문 등록 orderWrite - Service");

		orderDAO.orderWrite(orderDTO);

	}

	// 회원 정보 조회
	@Override
	public MemberAddressDTO memberAddress(String userId) throws Exception {

		logger.info("회원 정보 조회 memberAddress - Service");

		return orderDAO.memberAddress(userId);
	}

	// 주문 조회
	@Override
	public OrderDTO orderView(int orderNum, String userId) throws Exception {

		logger.info("주문 조회 orderView - Service");

		return orderDAO.orderView(orderNum, userId);
	}

	// 주문 목록
	@Override
	public List<OrderDTO> orderList(OrderDTO orderDTO) throws Exception {

		logger.info("주문 목록 orderList - orderService");

		return orderDAO.orderList(orderDTO);
	}

	// 주문 상세 목록
	@Override
	public List<OrderDetailDTO> orderDetailList(OrderDetailDTO orderDetailDTO) throws Exception {

		logger.info("주문 상세 목록 orderDetailList - orderService");

		return orderDAO.orderDetailList(orderDetailDTO);
	}

}
