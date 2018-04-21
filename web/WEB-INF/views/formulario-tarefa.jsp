<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Nova tarefa</title>
</head>
<body>

<h1>Nova tarefa</h1>

<form:errors path="tarefa.*" />
<form action="/adicionaTarefa" method="post">
	<textarea name="descricao"></textarea>
	<button>Adicionar tarefa</button>
</form>

</body>
</html>
