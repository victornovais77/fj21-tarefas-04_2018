<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Login Form</title>
</head>
<body>

${param.erro}

<h1>Login form</h1>
<form action="/efetuaLogin" method="post">
	
	Login:
	<input type="text" name="login">
	
	Senha:
	<input type="password" name="senha">
	
	<button>Logar</button>
</form>

</body>
</html>
