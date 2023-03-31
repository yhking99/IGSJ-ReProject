package ezen.project.IGSJ.order.dao;

import ezen.project.IGSJ.order.domain.OrderDTO;

public interface OrderDAO {
	
	//주문 정보
	public void orderInfo(OrderDTO orderDTO) throws Exception;
}
