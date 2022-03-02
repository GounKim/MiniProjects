package com.service.goods;

import java.util.List;

import com.dto.goods.GoodsDTO;

public interface GoodsService {
	
	public List<GoodsDTO> goodsList(String gCategory) throws Exception;
	public GoodsDTO goodsRetrieve(String gCode) throws Exception;
}
