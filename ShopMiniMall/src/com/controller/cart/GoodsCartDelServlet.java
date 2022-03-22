package com.controller.cart;

import java.io.IOException;
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
 * Servlet implementation class GoodsCartDelServlet
 */
@WebServlet("/GoodsCartDelServlet")
public class GoodsCartDelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String next = "";
		
		if (dto != null) {
			
			CartService service = new CartServiceImpl();
			try {
				int result = service.cartDel(Integer.parseInt(num));
				next = "GoodsCartListServlet";
			} catch (Exception e) {
				e.printStackTrace();
				next = "error/error.jsp?errorMessage=CartAdd 요청 시 예외 발생";
			}
		} else {
			next = "member/sessionInvalidate.jsp";
		}
		response.sendRedirect(next);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
