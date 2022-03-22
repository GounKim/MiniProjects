package com.service.cart;

import java.util.HashMap;
import java.util.List;

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

	@Override
	public List<CartDTO> cartList(String userid) throws Exception {
		List<CartDTO> list = null;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			list = dao.cartList(session, userid);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int cartUpdate(HashMap<String, Integer> map) throws Exception {
		int num = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			num = dao.cartUpdate(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int cartDel(int num) throws Exception {
		int result = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			result = dao.cartDel(session, num);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int cartDelAll(String userid) throws Exception {
		int result = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			result = dao.cartDelAll(session, userid);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

}
