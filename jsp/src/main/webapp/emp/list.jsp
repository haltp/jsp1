<%@ page import="java.util.ArrayList"%>
<%@ page import="emp.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/list.jsp</title>
</head>
<body>
	<c:forEach items="${list}" var="emp">
${emp.first_name} ${emp.email} ${emp.salary}
<fmt:formatDate value="${emp.hire_date}" />
		<br>
	</c:forEach>

	<my:login />
	<my:paging />
	이름:
	<%=((ArrayList<EmpVO>) request.getAttribute("list")).get(0).getFirst_name()%>
	<hr>
	이름 : ${requestScope.list[0].getLast_name() }
	<hr>
	컨텍스트(어플이름) : ${pageContext.request.contextPath }
	<!-- 중요 -->
	<%=request.getHeader("User-Agent")%>
	<br>
	<my:login />
	<my:paging />
</html>