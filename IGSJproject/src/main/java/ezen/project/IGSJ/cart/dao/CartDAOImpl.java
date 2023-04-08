package ezen.project.IGSJ.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.cart.domain.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {

	private static final Logger logger = LoggerFactory.getLogger(CartDAOImpl.class);

	private static final String NAME_SPACE = "mappers.cartMapper";

	@Autowired
	private SqlSession sqlSession;

	// 장바구니 등록
	@Override
	public int cartWrite(List<CartDTO> cartDTO) throws Exception {
		
		int numOfAdded = 0;
		
		for (int i = 0; i < cartDTO.size(); i++) {
			
			logger.info("장바구니 등록 - DAO");
			
			numOfAdded += sqlSession.insert(NAME_SPACE + ".cartWrite", cartDTO.get(i));
		}
		return numOfAdded;
	} // cartWrite()

	// 장바구니 중복 확인
	@Override
	public int cartSelect(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 중복 확인 cartSelect - DAO");

		return sqlSession.selectOne(NAME_SPACE + ".cartSelect", cartDTO);
	}

	// 장바구니 중복 수량 증가
	@Override
	public int cartUpdate(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 중복 수량 증가 cartUpdate - DAO");

		return sqlSession.update(NAME_SPACE + ".cartUpdate", cartDTO);
	}

	// 장바구니 목록
	@Override
	public List<CartDTO> cartList(String userId) throws Exception {

		logger.info("장바구니 목록 cartList - DAO");

		return sqlSession.selectList(NAME_SPACE + ".cartList", userId);
	}

	// 장바구니 삭제
	@Override
	public int cartDelete(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 삭제 cartDelete - DAO");

		return sqlSession.delete(NAME_SPACE + ".cartDelete", cartDTO);

	}

	// 장바구니 수량 수정
	@Override
	public int modifyCart(CartDTO cartDTO) throws Exception {

		logger.info("장바구니 수정 modifyCart - DAO");

		return sqlSession.update(NAME_SPACE + ".modifyCart", cartDTO);
	}

}
