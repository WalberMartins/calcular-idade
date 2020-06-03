<%@page import="entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Editar Usuario</title>
</head>
	<body>
		<% 
			Usuario user = (Usuario) request.getAttribute("usr");
			String pos = request.getParameter("posicao");
		%>
		<div align="center">
			<form action="crud" method="post">
				<label>Nome</label>
				<br/>
				<input type="text" name="nomeUsuario" value=<%=user.getNome()%>>
				<br/>
				<br/>
				<label>Data Nacimento</label>
				<br/>
				<input type="date" name="dataNascimentoUsuario" value=<%=user.getDataNascimento()%>>
				<br/>
				<br/>
				<label>Email</label>
				<br/>
				<input type="email" name="emailUsuario" value=<%=user.getEmail()%>>
				<br/>
				<br/>
				<label>Senha</label>
				<br/>
				<input type="password" name="senhaUsuario" value=<%=user.getSenha()%>>
				<br/>
				<br/>
				<input type="hidden" name="posicao" value=<%=pos%>>
				<input type="submit" value="enviar">
			</form>	
		</div>
	</body>
</html>