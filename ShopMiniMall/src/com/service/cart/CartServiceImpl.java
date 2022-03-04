package com.service.cart;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.cart.CartDAO;
import com.dto.cart.CartDTO;

public class CartServiceImpl implements CartService {

	@Override
	public int cartAdd(CartDTO dto) throws Exception {
		int num = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			num = dao.cartAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

}
