<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Formulário de alteração da tarefa</title>
</head>
<body>

<h1>Formulário de alteração da tarefa</h1>

<form action="/altera" method="post">

	<input type="hidden" name="id" value="${tarefa.id}">

	Descrição:
	<textarea name="descricao" cols="30" rows="10">${tarefa.descricao}</textarea>
	
	Finalizado ?:
	<input type="checkbox" name="finalizado" ${tarefa.finalizado ? 'checked' : ''}>
	
	Data de finalização:
	<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />"> 
	
	<button>Alterar</button>
</form>

</body>
</html>
