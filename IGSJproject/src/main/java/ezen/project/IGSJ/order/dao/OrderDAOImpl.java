package ezen.project.IGSJ.order.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ezen.project.IGSJ.order.domain.OrderDTO;

public class OrderDAOImpl implements OrderDAO{
	
private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "mappers.orderMapper";

	//주문 등록
	@Override
	public void orderWrite(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문등록 orderWrite - DAO");
		
		sqlSession.insert(NAME_SPACE + ".orderWrite", orderDTO);
		
	}
	
	
	
}
