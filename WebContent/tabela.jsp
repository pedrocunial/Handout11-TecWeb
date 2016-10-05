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
	<%@ page import="java.util.*, dbtest.*" %>
	<table border='1'>
<%-- 		<% DAO dao = new DAO();
		List<Pessoas> pessoas = dao.getLista(); %>
		<tr>
			<td>Nome</td>
			<td>Nascimento</td>
			<td>Altura</td>
			<td>Passaporte</td>
		</tr>
		<% for(Pessoas pessoa : pessoas) { %>
		<tr>
			<td><%= pessoa.getNome() %></td>
			<td><%= pessoa.getNascimento().getTime() %></td>
			<td>
				<%= String.valueOf(pessoa.getAltura() * 3.28) + "ft" %>
			</td>
			<td><%= pessoa.getPassaporte() %></td>
		</tr>
		<% } %>	
	</table>
	<% Date date = new Date();
	out.println(date.toLocaleString()); %>
--%>
	<%-- <c:import url="tabela.jsp"/> --%>
	<jsp:useBean id="dao" class="dbtest.DAO"/>
	
	<table border="1">
		
		<tr>
			
			<td><b>#</b></td>
			<td><b>Nome</b></td>
			<td><b>Data de Nascimento</b></td>
			<td><b>Altura</b></td>
			<td><b>Passaporte</b></td>
			
		</tr>
		<c:forEach var="pessoa" items="${ dao.lista }" varStatus="id">
			<tr bgcolor="#${ id.count % 2 == 0 ? 'bbffff' : 'ffffbb'}">
				<td>${ pessoa.id }</td>
				<td>${ pessoa.nome }</td>
				<td>
					<fmt:formatDate
					 value="${ pessoa.nascimento.time }"
					 pattern="dd/MM/yyyy"/>
				</td>
				<td>${ pessoa.altura }</td>
				<td>${ pessoa.passaporte }</td>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>