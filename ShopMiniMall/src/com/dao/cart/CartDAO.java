package com.dao.cart;

import org.apache.ibatis.session.SqlSession;

import com.dto.cart.CartDTO;

public class CartDAO {

	public int cartAdd(SqlSession session, CartDTO dto) throws Exception {
		return session.insert("com.config.CartMapper.cartAdd", dto);
	}
}
