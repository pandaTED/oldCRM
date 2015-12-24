<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/panda" prefix="panda"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
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

	<table frame="border" width="85%">
		<tr>
			<td>客户姓名</td>
			<td>性别</td>
			<td>生日</td>
			<td>手机</td>
			<td>邮箱</td>
			<td>爱好</td>
			<td>类型</td>
			<td>备注</td>
			<td>操作</td>
			<tr>

				<c:forEach var="c" items="${requestScope.pagebean.list}"
					varStatus="status">
					<tr class="${status.count%2==0?'even':'odd' }">
						<td>${c.name }</td>
						<td>${c.gender }</td>
						<td>${c.birthday }</td>
						<td>${c.cellphone }</td>
						<td>${c.email }</td>
						<td>${panda:sub(c.preference) }</td>
						<td>${c.type }</td>
						<td>${panda:sub(c.description) }</td>
						<td><a href="#">修改</a> <a href="#">删除</a></td>
						<tr>
				</c:forEach>
	</table>
	<br />

	<script type="text/javascript">
    	function gotopage(currentpage){
    		if(currentpage<1 || currentpage!=parseInt(currentpage) || currentpage>${pageBean.pageNum}){
    			alert("请输入有效值！！");
    			document.getElementById("pagenum").value = '';
    		}else{
	    		var pagesize = document.getElementById("pagesize").value;
	    		window.location.href = '${pageContext.request.contextPath}/servlet/ListCustomerServlet?currentPage=' + currentpage + '&pageNum=' + pageNum;
    		}
    	}
    	
    	function changesize(pagesize,oldvalue){
    		if(pagesize<0 || pagesize!=parseInt(pagesize)){
    			alert("请输入合法值！！");
    			document.getElementById("pagesize").value = oldvalue;
    		}else{
    			window.location.href = '${pageContext.request.contextPath}/servlet/ListCustomerServlet?pagesize=' + pagesize;
    		}
    	}
    </script>

	共[${pagebean.totalrecord }]条记录, 每页
	<input type="text" id="pagesize" value="${pagebean.pagesize }"
		onchange="changesize(this.value,${pagebean.pagesize })"
		style="width: 30px" maxlength="2">条, 共[${pagebean.pageNum }]页,
		当前[${pagebean.currentpage }]页 &nbsp;&nbsp;&nbsp; <a
		href="javascript:void(0)"
		onclick="gotopage(${pagebean.previouspage })">上一页</a> <c:forEach
			var="pagenum" items="${pagebean.pagebar}">
			<c:if test="${pagenum==pagebean.currentpage}">
				<font color="red">${pagenum }</font>
			</c:if>

			<c:if test="${pagenum!=pagebean.currentpage}">
				<a href="javascript:void(0)" onclick="gotopage(${pagenum })">${pagenum }</a>
			</c:if>
		</c:forEach> <a href="javascript:void(0)"
		onclick="gotopage(${pagebean.nextpage })">下一页</a> <input type="text"
		id="pagenum" style="width: 30px"> <input type="button"
			value=" GO "
			onclick="gotopage(document.getElementById('pagenum').value)">
</body>
</html>
