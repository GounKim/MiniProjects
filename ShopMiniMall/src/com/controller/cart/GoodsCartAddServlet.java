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
 * Servlet implementation class GoodsCartAddServlet
 */
@WebServlet("/GoodsCartAddServlet")
public class GoodsCartAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String next = "";
		
		if (dto != null) {
			String userid = dto.getUserid();
			String gImage = request.getParameter("gImage");
			String gCode = request.getParameter("gCode");
			String gName = request.getParameter("gName");
			String gPrice = request.getParameter("gPrice");
			String gSize = request.getParameter("gSize");
			String gColor = request.getParameter("gColor");
			String gAmount = request.getParameter("gAmount");
			
			CartDTO cartDTO = new CartDTO();
			cartDTO.setUserid(userid);
			cartDTO.setgImage(gImage);
			cartDTO.setgCode(gCode);
			cartDTO.setgName(gName);
			cartDTO.setgPrice(Integer.parseInt(gPrice));
			cartDTO.setgSize(gSize);
			cartDTO.setgColor(gColor);
			cartDTO.setgAmount(Integer.parseInt(gAmount));
			
			System.out.println(cartDTO.toString());
			CartService service = new CartServiceImpl();
			try {
				int num = service.cartAdd(cartDTO);
				next = "cart/cartAddSuccess.jsp";
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
