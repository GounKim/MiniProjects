package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		
		MemberService service = new MemberServiceImpl();
		String mesg = "";
		
		try {
			int num = service.idDuplicateCheck(userid);
			
			if(num == 0) {
				mesg = "아이디 사용 가능";
			} else {
				mesg = "아이디 중복";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("test/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(mesg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
