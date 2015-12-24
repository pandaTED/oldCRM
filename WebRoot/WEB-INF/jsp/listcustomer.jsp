<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/panda" prefix="panda"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>列出所有客户</title>
<style type="text/css">
.even {
	background-color: #FFFF00
}

.odd {
	background-color: #FFCCFF
}

tr:hover {
	background-color: #FF99FF
}
</style>
</head>

<body style="text-align: center;">
	<table frame="border" width="85%" align="center">
		<tr>
			<td>客户姓名</td>
			<td>客户性别</td>
			<td>生日</td>
			<td>手机</td>
			<td>电子邮箱</td>
			<td>爱好</td>
			<td>类型</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach var="c" items="${requestScope.pageBean.customerList}"
			varStatus="status">
			<tr class="${status.count%2==0?'even':'odd'}">
				<td>${c.name }</td>
				<td>${c.gender }</td>
				<td>${c.birthday }</td>
				<td>${c.cellphone }</td>
				<td>${c.email }</td>
				<td>${panda:sub(c.preference)}</td>
				<td>${c.type }</td>
				<td>${panda:sub(c.description)}</td>
				<td><a
					href="${pageContext.request.contextPath}/servlet/UpdateCustomer?id=${c.id}">修改</a>
					<a href="javascript:void(0)" onclick="delcustomer('${c.id}')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />

	<script type="text/javascript">
	function gotopage(currentPage) {
		var pagess = document.getElementById("pagesize").value;
		window.location.href ='${pageContext.request.contextPath}/servlet/ListCustomerServlet?currentPage='+currentPage+'&itemPerPageNum='+pagess ;	
	}
	
	function chagepagesize(itemPerPageNum){
		
		window.location.href ='${pageContext.request.contextPath}/servlet/ListCustomerServlet?itemPerPageNum='+itemPerPageNum;
		
	} 
	
	function delcustomer(id) {
		if(window.confirm("你确定要删除该项数据吗？")){	
			window.location.href ='${pageContext.request.contextPath}/servlet/DeleteCustomer?id='+id;
		}
	}
	
	
	
	</script>

	总计 [${pageBean.itemNum}]条数据， 每页显示
	<input type="text" id="pagesize" style="width: 20px;"
		value=${pageBean.itemPerPageNum } onchange="chagepagesize(this.value)">
	条 ， 共[${pageBean.pageNum}]页， 当前第[${pageBean.currentPage}]页 ，
	<a href="javascript:void(0)"
		onclick="gotopage(${pageBean.previousPage})">上一页</a>
	<c:forEach var="pb" items="${pageBean.pagebar}">
		<c:if test="${pb == pageBean.currentPage}">
			<font color="red"> ${pb} </font>
		</c:if>
		<c:if test="${pb != pageBean.currentPage}">
			<a href="javascript:void(0)" onclick="gotopage(${pb})"> ${pb} </a>
		</c:if>

	</c:forEach>
	<a href="javascript:void(0)" onclick="gotopage(${pageBean.nextPage})">下一页</a>

	跳转到第
	<input type="text" style="width: 20px;" id="gopage">页
	<input type="button" value="go"
		onclick="gotopage(document.getElementById('gopage').value)" />

</body>
</html>
