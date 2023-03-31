package ezen.project.IGSJ.order.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.order.domain.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "mappers.orderMapper";

	//주문 정보
	@Override
	public void orderInfo(OrderDTO orderDTO) throws Exception {
		sqlSession.insert(NAME_SPACE + ".orderInfo", orderDTO);
	}

	
	
	
}
