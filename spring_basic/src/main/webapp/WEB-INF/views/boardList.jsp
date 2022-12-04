<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fastcampus</title>
<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
</head>
<body>
	<div id="menu">
		<ul>
			<li id="logo">fastcampus</li>
			<li><a href="<c:url value='/'/>">Home</a></li>
			<li><a href="<c:url value='/board/list'/>">Board</a></li>
			<li><a href="<c:url value='/login/login'/>">login</a></li>
			<li><a href="<c:url value='/register/add'/>">Sign in</a></li>
			<li><a href=""><i class="fas fa-search small"></i></a></li>
		</ul>
	</div>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>이름</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.bno}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.reg_date}</td>
				<td>${board.view_cnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>