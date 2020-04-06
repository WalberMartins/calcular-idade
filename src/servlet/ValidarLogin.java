package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;

@WebServlet("/validarLogin")
public class ValidarLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("user");
		String senha = req.getParameter("password");
		
		Cliente cliente = new Cliente(usuario, senha);

		if(validarLogin(cliente))
			req.getRequestDispatcher("calcular-idade.html").forward(req, resp);
		else
			resp.sendRedirect("usuario-invalido.html");
		
	}
	
	private boolean validarLogin(Cliente cliente) {
		Cliente clienteCadastrado = new Cliente("admin", "12345");
		if(clienteCadastrado.equals(cliente)) {
				return true;
		}
		return false;
	}
	
}
