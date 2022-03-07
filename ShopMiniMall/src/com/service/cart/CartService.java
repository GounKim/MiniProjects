package com.service.cart;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.cart.CartDTO;

public interface CartService {
	
	public int cartAdd(CartDTO dto) throws Exception;
	public List<CartDTO> cartList(String userid) throws Exception;
	public int cartUpdate(HashMap<String, Integer> map) throws Exception;
}
