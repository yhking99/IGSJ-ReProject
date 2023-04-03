package ezen.project.IGSJ.order.dao;

import java.util.List;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;

public interface OrderDAO {
	// 주문 등록 불러오기
	public OrderDTO orderPage(String userId) throws Exception;
	
	// 주문 등록
	public void orderWrite(OrderDTO orderDTO) throws Exception;

	// 회원 정보 조회
	public MemberAddressDTO memberAddress(String userId) throws Exception;

	// 주문 조회
	public OrderDTO orderView(int orderNum, String userId) throws Exception;

	// 주문 목록
	public List<OrderDTO> orderList(OrderDTO orderDTO) throws Exception;

	// 주문 상세 목록
	public List<OrderDetailDTO> orderDetailList(OrderDetailDTO orderDetailDTO) throws Exception;


}
