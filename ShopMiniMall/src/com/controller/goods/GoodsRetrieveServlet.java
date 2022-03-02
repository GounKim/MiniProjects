package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.goods.GoodsListServlet;
import com.dto.goods.GoodsDTO;
import com.service.goods.GoodsService;
import com.service.goods.GoodsServiceImpl;

/**
 * Servlet implementation class GoodsRetrieveServlet
 */
@WebServlet("/GoodsRetrieveServlet")
public class GoodsRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode = request.getParameter("gCode");
		
		String next = "";
		GoodsService service = new GoodsServiceImpl();
		try {
			GoodsDTO dto = service.goodsRetrieve(gCode);
			request.setAttribute("retrieve", dto);
			next = "goodsRetrieve.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Retrieve 요청 시 예외 발생");
			next = "error/error.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
