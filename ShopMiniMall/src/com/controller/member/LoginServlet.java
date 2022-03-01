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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		HashMap<String, String> map = new HashMap<>();
		map.put("id", userid);
		map.put("pw", passwd);
		
		MemberService service = new MemberServiceImpl();
		String next = "";
		try {
			MemberDTO dto = service.login(map);
			
			// 로그인 시 해당 id/pw가 존재하는지 체크
			if(dto != null) {
				next = "Main";
				
				HttpSession session = request.getSession();
				session.setAttribute("login", dto);
			} else {
				next = "member/loginFail.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//request.setAttribute("errorMessage", "로그인 오류"); -> 나중에 설정해보기(sendRedirect는 값 못넘김)
			next = "error/error.jsp";
		}

		response.sendRedirect(next);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
