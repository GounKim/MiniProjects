<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mini Mall</title>
</head>
<body>
	<h1>상품 상세 화면입니다.</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/menu.jsp" flush="true" /><br>
	<hr>
	<jsp:include page="goods/goodsRetrieve.jsp" flush="true" />
</body>
</html>