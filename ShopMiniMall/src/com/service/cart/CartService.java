package com.service.cart;

import com.dto.cart.CartDTO;

public interface CartService {
	
	public int cartAdd(CartDTO dto) throws Exception;
}
