package ezen.project.IGSJ.order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.order.domain.OrderDTO;
import ezen.project.IGSJ.order.domain.OrderDetailDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

	@Autowired
	private SqlSession sqlSession;

	private static final String NAME_SPACE = "mappers.orderMapper";
	
	//주문 페이지 불러오기
	@Override
	public OrderDTO orderPage(String userId) throws Exception {
		
		return sqlSession.selectOne(NAME_SPACE+ ".getOrderPage" , userId);
		
	}
	
	// 주문 등록
	@Override
	public void orderWrite(OrderDTO orderDTO) throws Exception {

		logger.info("주문등록 orderWrite - OrderDAO");

		sqlSession.insert(NAME_SPACE + ".orderWrite", orderDTO);
	}

	// 회원 정보 조회
	@Override
	public MemberAddressDTO memberAddress(String userId) throws Exception {

		logger.info("회원 정보 조회 memberAddress - orderDAO");

		return sqlSession.selectOne(NAME_SPACE + "memberAddress", userId);
	}

	// 주문 조회
	@Override
	public OrderDTO orderView(int orderNum, String userId) throws Exception {
		
		logger.info("주문 조회 orderView - orderDAO");
		
		//HashMap
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNum", orderNum);
		map.put("userId", userId);
		
		return sqlSession.selectOne(NAME_SPACE + ".orderView", map);
	}

	// 주문 목록
	@Override
	public List<OrderDTO> orderList(OrderDTO orderDTO) throws Exception {

		logger.info("주문 목록 orderList - orderDAO");

		return sqlSession.selectList(NAME_SPACE + ".orderList", orderDTO);
	}

	// 주문 상세 목록
	@Override
	public List<OrderDetailDTO> orderDetailList(OrderDetailDTO orderDetailDTO) throws Exception {

		logger.info("주문 상세 목록 orderDetailList - orderDAO");

		return sqlSession.selectList(NAME_SPACE + ".orderDetailList", orderDetailDTO);

	}

}
