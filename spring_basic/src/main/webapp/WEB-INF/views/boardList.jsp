<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loginId" value="${sessionScope.id == null ? '' : sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
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
			<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
			<li><a href="<c:url value='/register/add'/>">Sign in</a></li>
			<li><a href=""><i class="fa fa-search"></i></a></li>
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
	<br>
	<div>
		<c:if test="${pageHandler.showPrev}">
			<a
				href="<c:url value="/board/list?page=${pageHandler.beginPage-1}&pageSize=${pageHandler.pageSize}"/>">[PREV]</a>
		</c:if>
		<c:forEach var="i" begin="${pageHandler.beginPage}"
			end="${pageHandler.endPage}">
			<a
				href="<c:url value="/board/list?page=${i}&pageSize=${pageHandler.pageSize}"/>">${i}</a>
		</c:forEach>
		<c:if test="${pageHandler.showNext}">
			<a
				href="<c:url value="/board/list?page=${pageHandler.endPage+1}&pageSize=${pageHandler.pageSize}"/>">[NEXT]</a>
		</c:if>
	</div>
</body>
</html>