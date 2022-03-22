package com.controller.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.goods.GoodsListServlet;
import com.dto.cart.CartDTO;
import com.dto.goods.GoodsDTO;
import com.dto.member.MemberDTO;
import com.service.cart.CartService;
import com.service.cart.CartServiceImpl;
import com.service.goods.GoodsService;
import com.service.goods.GoodsServiceImpl;

/**
 * Servlet implementation class GoodsCartUpdateServlet
 */
@WebServlet("/GoodsCartUpdateServlet")
public class GoodsCartUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		String amount = request.getParameter("amount");
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", Integer.parseInt(num));
		map.put("gAmount", Integer.parseInt(amount));
		
		// 로그인 세션 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String next = "";
		
		if (dto != null) {
			CartService service = new CartServiceImpl();
			try {
				int result = service.cartUpdate(map);
			} catch (Exception e) {
				e.printStackTrace();
				next = "error/error.jsp?errorMessage=CartAdd 요청 시 예외 발생";
				response.sendRedirect(next);
			}
		} else {
			next = "member/sessionInvalidate.jsp";
			response.sendRedirect(next);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
