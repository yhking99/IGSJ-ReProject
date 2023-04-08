package ezen.project.IGSJ.order.dao;

import java.util.List;

import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;
import ezen.project.IGSJ.order.domain.PaymentDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;

public interface OrderDAO {
	// 주문 등록 불러오기
	public OrderDTO orderPage(String userId) throws Exception;
	
	// 카트에 담긴 상품 정보 불러오기
	public List<OrderDTO> productOrderPage(String userId) throws Exception;
	
	//주문정보 등록하기(수령인정보)
	public void pay(OrderDTO orderDTO,OrderDetailDTO orderDetailDTO, PaymentDTO paymentDTO) throws Exception;

	// 주문내역조회페이지 불러오기
	public List<OrderDTO> orderListPage(String userId) throws Exception;
	
	// 주문상세내역조회페이지 불러오기
	public OrderDTO orderDetailPage(String orderNum) throws Exception;

	// 결제완료페이지 불러오기
	public OrderDTO orderFinishPage(String orderNum) throws Exception;
	
	
}
