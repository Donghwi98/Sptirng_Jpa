<!DOCTYPE html>
<%@ taglib prefix="c" uri="http//java.sun.con/jsp/jstl/core" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div>
		<c:if test="${start ne 1}">
			<span><a href="list?pageNum=${start - 5}">[이전]</a></span>&nbsp;&nbsp;
		</c:if>
		
		<c:forEach var="i" begin="${start}" end="${(end < realEnd) ? end : realEnd}">
			<a href="list?pageNum=${i}">${i}</a>&nbsp;&nbsp;
		</c:forEach>
		
		<c:if test="${end < realEnd}">
			<span><a href="list?pageNum=${end + 1}">[다음]</a></span>
		</c:if>
	</div>
</body>
</html>