<%@page import="com.dto.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("login");
	if (dto == null) {
%>
		<a href="LoginUIServlet">로그인</a>
		<a href="MemberUIServlet">회원가입</a>
<%
	} else {
%>
		안녕하세요 <%= dto.getUsername() %>님 &nbsp;&nbsp;
		<a href="LogoutServlet">로그아웃</a>
		<a href="MyPageServlet">mypage</a>
		<a href="GoodsCartListServlet">장바구니 목록</a>
<%
	}// end if
%>