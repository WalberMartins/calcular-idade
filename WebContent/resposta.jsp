<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>resposta</title>
</head>
<body>
	<form action="calcular-idade.html">
		<input type="submit" value="Voltar">
	</form>
	<p>Você tem <%= request.getAttribute("idade") %> anos.</p>
</body>
</html>