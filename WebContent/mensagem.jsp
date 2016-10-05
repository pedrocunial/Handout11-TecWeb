<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String mensagem = "uma mensagem inserida no html"; %>
	<% out.println(mensagem); %>
	<br/>
	<% String mensagem2 = "outra forma de inserir texto"; %>
	<%= mensagem2 %>
	<br />
	<% System.out.println("Esse texto aparece no console do tomcat"); %>
	<br>
	<% out.println("Conectado na porta:" + request.getRemotePort()); %>
</body>
</html>