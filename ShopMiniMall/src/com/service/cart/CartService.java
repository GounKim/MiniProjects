package com.service.cart;

import java.util.List;

import com.dto.cart.CartDTO;

public interface CartService {
	
	public int cartAdd(CartDTO dto) throws Exception;
	public List<CartDTO> cartList(String userid) throws Exception;
}
