<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
 $(function(){
	 //이메일 중복 체크
	 $("#btnEmail").on("click", function(){
		 $.ajax({
			 url : "../EmailCheck",
			 data : "email=" + $("#email").val(),
			 success : function(response){$("#emailResult").html(response);
			}
		 });
	 });
 });
 
 
 
 
 
</script>
</head>
<body>
<h3 id="top">사원등록</h3>
<c:set var="url" value="../EmpInsert"/>
<c:if test="${not empty empVO.employee_id}">
</c:if>
<c:set var="url" value="../EmpUpdate"/>
<form action="${url}" method="post" name="frm">
	employee_id <input type="number" name="employee_id" <c:if test="${not empty empVO.employee_id} }"> readonly="readonly"</c:if> ><br>
	first_name  <input name="first_name" value="${empVO.first_name}"><br>
	last_name   <input name="last_name"><br>
	email       <input type="email" name="email" value="${empVO.email}">
				<button type="button" id="btnEmail">중복체크</button>
				<span id="emailResult"></span><br>
	phone_number<input type="text" name="phone_number"><br>
	hire_date   <input type="date" name="hire_date"><br>
	department_id 
				<c:forEach items="${deptList}" var="dept">
				<input type="radio" name="DEPARTMENT_ID"
				value="${dept.DEPARTMENT_ID}" 
				<c:if test="${dept.DEPARTMENT_ID == empVO.department_id}">checked="checked" </c:if>>
				${dept.DEPARTMENT_NAME}
				</c:forEach>
				<br>	 
	job_id      <select name="job_id">
				<c:forEach items="${jobList}" var="job">
				<option value="${job.JOB_ID}" selected="selected">
				${job.JOB_TITLE}
				</option>
				</c:forEach>
				</select>
				<br>
	
	
				  
	manager_id 
	<input type="text" name="manager_id">
	<input type="text" name="name">
	<button type="button" onclick="search()">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>

</body>
</html>
