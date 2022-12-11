<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loginId"
	value="${sessionScope.id == null ? '' : sessionScope.id}" />
<c:set var="loginOutLink"
	value="${loginId=='' ? '/login/login' : '/login/logout'}" />
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fastcampus</title>
<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	font-family: "Noto Sans KR", sans-serif;
}

a {
	text-decoration: none;
	color: black;
}

button, input {
	border: none;
	outline: none;
}

.board-container {
	width: 60%;
	height: 1200px;
	margin: 0 auto;
	/* border: 1px solid black; */
}

.search-container {
	background-color: rgb(253, 253, 250);
	width: 100%;
	height: 110px;
	border: 1px solid #ddd;
	margin-top: 10px;
	margin-bottom: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.search-form {
	height: 37px;
	display: flex;
}

.search-option {
	width: 100px;
	height: 100%;
	outline: none;
	margin-right: 5px;
	border: 1px solid #ccc;
	color: gray;
}

.search-option>option {
	text-align: center;
}

.search-input {
	color: gray;
	background-color: white;
	border: 1px solid #ccc;
	height: 100%;
	width: 300px;
	font-size: 15px;
	padding: 5px 7px;
}

.search-input::placeholder {
	color: gray;
}

.search-button {
	/* 메뉴바의 검색 버튼 아이콘  */
	width: 20%;
	height: 100%;
	background-color: rgb(22, 22, 22);
	color: rgb(209, 209, 209);
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 15px;
}

.search-button:hover {
	color: rgb(165, 165, 165);
}

table {
	border-collapse: collapse;
	width: 100%;
	border-top: 2px solid rgb(39, 39, 39);
}

tr:nth-child(even) {
	background-color: #f0f0f070;
}

th, td {
	width: 300px;
	text-align: center;
	padding: 10px 12px;
	border-bottom: 1px solid #ddd;
}

td {
	color: rgb(53, 53, 53);
}

.no {
	width: 150px;
}

.title {
	width: 50%;
}

td.title {
	text-align: left;
}

td.writer {
	text-align: left;
}

td.viewcnt {
	text-align: right;
}

td.title:hover {
	text-decoration: underline;
}

.paging {
	color: black;
	width: 100%;
	align-items: center;
}

.page {
	color: black;
	padding: 6px;
	margin-right: 10px;
}

.paging-active {
	background-color: rgb(216, 216, 216);
	border-radius: 5px;
	color: rgb(24, 24, 24);
}

.paging-container {
	width: 100%;
	height: 70px;
	display: flex;
	margin-top: 50px;
	margin: auto;
}

.btn-write {
	background-color: rgb(236, 236, 236); /* Blue background */
	border: none; /* Remove borders */
	color: black; /* White text */
	padding: 6px 12px; /* Some padding */
	font-size: 16px; /* Set a font size */
	cursor: pointer; /* Mouse pointer on hover */
	border-radius: 5px;
	margin-left: 30px;
}

.btn-write:hover {
	text-decoration: underline;
}
</style>
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
				<td><a href="<c:url value="/board/read?bno=${board.bno}&page=${pageHandler.page}&pageSize=${pageHandler.pageSize}"/>">${board.title}</a></td>
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