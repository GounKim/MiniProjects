package com.controller.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.cart.CartDTO;
import com.dto.member.MemberDTO;
import com.service.cart.CartService;
import com.service.cart.CartServiceImpl;

/**
 * Servlet implementation class GoodsCartListServlet
 */
@WebServlet("/GoodsCartListServlet")
public class GoodsCartListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 세션 확인하기
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String next = "";
		
		if(dto != null) {
			String userid = dto.getUserid();
			
			CartService service = new CartServiceImpl();
			try {
				List<CartDTO> cartList = service.cartList(userid);
				request.setAttribute("cartList", cartList);
				next = "cartList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "CartList 요청시 예외 발생");
				next = "error/error.jsp";
			}
		} else {
			next = "member/sessionInvalidate.jsp";
		}		
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
