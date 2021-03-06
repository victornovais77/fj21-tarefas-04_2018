<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Lista de tarefas</title>
</head>
<body>

<h1>Lista de tarefas - ${sessionScope.usuarioLogado.login}</h1>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado</th>
			<th>Data de finalização</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tarefa" items="${lista}">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<td id="tarefa-${tarefa.id}">
				<c:if test="${tarefa.finalizado}">
					Finalizada
				</c:if> 
				<c:if test="${not tarefa.finalizado}">
					<a href="#" onclick="finalizar(${tarefa.id})">Finalizar agora</a>
				</c:if>
				<td>
						<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
				</td>
				<td>
					<form action="/remove" method="post">
						<input type="hidden" name="id" value="${tarefa.id}">
						<button>Remover</button>
					</form>
				</td>
				<td>
					<a href="/mostraTarefa?id=${tarefa.id}">Alterar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="/formularioTarefa">Nova Tarefa</a>

<script src="/resources/js/jquery.js"></script>
<script>
	function finalizar(id) {
		$.post("/finaliza", {'id': id}, function() {
			$('#tarefa-' + id).html("Finalizada");
		});
	}
</script>

</body>
</html>


