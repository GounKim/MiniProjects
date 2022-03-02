package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String next = "";
		
		if(dto != null) {
			String userid = request.getParameter("userid");
			String post = request.getParameter("post");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String phone1 = request.getParameter("phone1");
			String phone2 = request.getParameter("phone2");
			String phone3 = request.getParameter("phone3");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			
			dto.setUserid(userid);
			dto.setPost(post);
			dto.setAddr1(addr1);
			dto.setAddr2(addr2);
			dto.setPhone1(phone1);
			dto.setPhone2(phone2);
			dto.setPhone3(phone3);
			dto.setEmail1(email1);
			dto.setEmail2(email2);
			
			MemberService service = new MemberServiceImpl();
			try {
				int num = service.memberUpdate(dto);
				next = "MyPageServlet";
				session.setAttribute("login", dto);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "MyPage Update 요청 시 예외 발생.");
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
