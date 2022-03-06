package com.dao.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.cart.CartDTO;

public class CartDAO {

	public int cartAdd(SqlSession session, CartDTO dto) throws Exception {
		return session.insert("com.config.CartMapper.cartAdd", dto);
	}
	
	public List<CartDTO> cartList(SqlSession session, String userid) throws Exception {
		return session.selectList("com.config.CartMapper.cartList", userid);
	}
}
