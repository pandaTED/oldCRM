<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!-- 这个地方是后加上的 -->

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
	<table frame="border" width="85%" align="center;">
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
		<c:forEach var="c" items="${requestScope.pageBean.customerList }"
			varStatus="status">
			<tr class="${status.count%2==0?'even':'odd'}">
				<td>${c.name }</td>
				<td>${c.gender }</td>
				<td>${c.birthday }</td>
				<td>${c.cellphone }</td>
				<td>${c.email }</td>
				<td>${c.preference }</td>
				<td>${c.type }</td>
				<td>${c.description }</td>
				<td><a href="#">修改</a> <a href="#">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<br /> 总计 [${pageBean.itemNum}]条数据 &nbsp;&nbsp; 每页显示
	<input type="text" value=${pageBean.itemPerPageNum}> 条
		&nbsp;&nbsp; <input type="button" value="上一页"> &nbsp; 当前第XXX页
			&nbsp; <input type="button" value="下一页"> &nbsp; 跳转到第__页 
</body>
</html>
