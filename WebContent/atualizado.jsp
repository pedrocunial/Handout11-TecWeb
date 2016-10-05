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
<%@ page import='java.util.*, dbtest.*, java.text.*' %>
<% 
	DAO dao = new DAO();
	Pessoas pessoa = new Pessoas();
	
	pessoa.setId(Integer.valueOf(request.getParameter("id")));
	pessoa.setNome(request.getParameter("nome"));
	pessoa.setAltura(Double.valueOf(request.getParameter("altura")));
	pessoa.setPassaporte(request.getParameter("passaporte"));
	String nascimento = request.getParameter("nascimento");
	Date data = null;
	try {
		data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		pessoa.setNascimento(dataNascimento);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	dao.altera(pessoa);
%>
Atualizado ${ param.nome }
<% dao.close(); %>


</body>
</html>