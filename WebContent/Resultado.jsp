<%@page import="entidades.Usuario"%>
<%@page import="dados.Dados"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Usuários</title>
	</head>
	<body>
		<% List<Usuario> list = Dados.getList();%>
	
		<form action="menu-principal.html">
			<input type="submit" value="Voltar">
		</form>
		<table border="1">
			<tr>
				<td>Sequencial</td>
				<td>Nome</td>
				<td>E-mail</td>
				<td>Senha</td>
				<td>Data Nascimento</td>
				<td>Edição</td>
			</tr>
			<% for(int i = 0; i < list.size(); i++){ %>
				<%Usuario user = list.get(i); %>
				<tr>
					<td><%= i + 1 %></td>
					<td><%= user.getNome() %></td>
					<td><%= user.getEmail() %></td>
					<td><%= user.getSenha() %></td>
					<td><%= user.getDataNascimento() %></td>
					<td><a href=<%= "crud?posicao=" + (i)%>>editar</a></td>
					<td><a href=<%= "crud?remover=" + (i)%>>remover</a></td>
				</tr>
			<% } %>
		</table>
		<form action="cadastro.html">
			<input type="submit" value="novo usuário">
		</form>	
	</body>
</html>