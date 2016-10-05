<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
	prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method='post' action='sucesso.jsp'>
	Nome: <input type='text' name='nome'><br>
	Nascimento: <input type='date' name='nascimento'><br>
	Altura: <input type='number' name='altura' step='0.01'><br>
	Passaporte: <input type='text' name='passaporte'><br>
	<input type='submit' value='Submit'>
</form>
</body>
</html>