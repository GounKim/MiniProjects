<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<script type="text/javascript">

	////////// 장바구니 개수 수정 ///////////
	var httpRequest;
	var global_num;
	
	function amountUpdate(num) {
		httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = responseFun;
		
		global_num = num;
		var input_amount = document.querySelector("#cart_amount" + num);
		var amount = input_amount.value;
		console.log(amount);
		var url = `GoodsCartUpdateServlet?num=\${num}&amount=\${amount}`;
		httpRequest.open("get", url, true);
		httpRequest.send(null);
	}
	
	function responseFun() {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			alert("갯수 수정 성공");
			var price = document.querySelector("#cart_price" + global_num).innerText;
			var amount = document.querySelector("#cart_amount" + global_num).value;
			document.querySelector("#sum" + global_num).innerText = price * amount;
		}
	}
	
	//////// 장바구니 개수 수정 END //////////
	
	// 장바구니 상품 삭제
	function delCart(num) {
		console.log("delCart", num);
		location.href = `GoodsCartDelServlet?num=\${num}`;
	}
	
	// 상품 전체 선택 (체크박스)
	function allCheck() {
		var allCheck = document.querySelector("#allCheck");
		var check = document.querySelectorAll(".check");
		
		check.forEach(function(data, idx) {
			data.checked = allCheck.checked;
		});
	}
	
</script>
 
 
<table width="90%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">
			&nbsp;&nbsp;&nbsp;
			<font size="5"><b>- 장바구니 -</b></font> 
			&nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
			<input type="checkbox" name="allCheck" id="allCheck" onclick="allCheck()"> 
				<strong>전체선택</strong>
		</td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>


<form name="myForm">
<c:forEach var="dto" items="${cartList}" varStatus="status">
		
	<input type="hidden" name="num" value="${dto.num}" id="${dto.num}">
	<input type="hidden" name="gImage" value="${dto.gImage}" id="gImage">
	<input type="hidden" name="gName" value="${dto.gName}" id="gName">
	<input type="hidden" name="gSize" value="${dto.gSize}" id="gSize">
	<input type="hidden" name="gColor" value="${dto.gColor}" id="gColor"> 
	<input type="hidden" name="gPrice" value="${dto.gPrice}" id="gPrice">
	
	<tr>
		<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check${dto.num}" class="check" value="${dto.num}">
		</td>
		<td class="td_default" width="80">
			${dto.num}
		</td>
		<td class="td_default" width="80">
			<img src="images/items/${dto.gImage}.gif" border="0" align="center" width="80" />
		</td>
		<td class="td_default" width="300" style='padding-left: 30px'>
			${dto.gName}<br> 
			<font size="2" color="#665b5f">
				[옵션 : 사이즈(${dto.gSize}), 색상(${dto.gColor})]
			</font>
		</td>
		
		<td class="td_default" align="center" width="110">
			<span id="cart_price${dto.num}">${dto.gPrice}</span>
		</td>
		
		<td class="td_default" align="center" width="90">
			<input class="input_default" type="text" name="cart_amount" 
					id="cart_amount${dto.num}" style="text-align: right" maxlength="3"
					size="2" value="${dto.gAmount}" />
		</td>
		
		<td>
			<input type="button" value="수정" onclick="amountUpdate(${dto.num})" />
		</td>
		<td class="td_default" align="center" width="80" style='padding-left: 5px'>
			<span id="sum${dto.num}">
				<fmt:formatNumber value="${dto.gPrice * dto.gAmount}" type="currency" />
			</span>
		</td>
		<td>
			<input type="button" value="주문" onclick="order('81','a')">
		</td>
		<td class="td_default" align="center" width="30" style='padding-left: 10px'>
			<input type="button" value="삭제" onclick="delCart(${dto.num})">
		</td>
		
		<td height="10"></td>
	</tr>	
</c:forEach>
</form>
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href="javascript:orderAllConfirm(myForm)"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="javascript:delAllCart(myForm)"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="index.jsp"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
