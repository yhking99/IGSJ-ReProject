package ezen.project.IGSJ.order.dao;

import ezen.project.IGSJ.order.domain.OrderDTO;

public interface OrderDAO {
	
	//주문서 작성
	public void orderWrite(OrderDTO orderDTO) throws Exception;
}
