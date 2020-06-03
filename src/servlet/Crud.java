package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.Dados;
import data.Data;
import entidades.Usuario;

@WebServlet("/crud")
public class Crud extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private List<Usuario> list;

	public Crud() {
		list = Dados.getList();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			if(request.getParameter("remover") != null) {
				Integer pos = Integer.parseInt(request.getParameter("remover"));
				Usuario usuario = list.get(pos);
				removerUsuario(usuario);
				
				response.sendRedirect("Resultado.jsp");
			}
			else {
				Integer pos = Integer.parseInt(request.getParameter("posicao"));
				request.setAttribute("usr", list.get(pos));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
			request.setAttribute("msg", e.getMessage());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Erro.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			Usuario user = extrairDadosFormulario(request);
			
			
			if( request.getParameter("posicao") != null) {

				Integer posicao = Integer.parseInt(request.getParameter("posicao"));
				
				atualizarUsuario(posicao, user);
			
			} else {
				
				inserirUsuario(user);			
			}

			if(request.getSession(false) != null)
				response.sendRedirect("Resultado.jsp");
			else
				response.sendRedirect("index.html");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("msg", e.getMessage());

			RequestDispatcher dispatcher = request.getRequestDispatcher("Erro.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void atualizarUsuario(Integer posicao, Usuario user) {
		list.set(posicao, user);		
	}

	private void inserirUsuario(Usuario user) {
		
		if(existeUsuario(user)) {
			throw new RuntimeException("E-mail já cadastrado");
		}
		
		list.add(user);
	}
	
	private void removerUsuario(Usuario usuario) {
		if(!existeUsuario(usuario)) {
			throw new RuntimeException("Usuario não existe");
		}
		
		list.remove(usuario);
	}

	// busca linear
	private boolean existeUsuario(Usuario user) {

		for (int i = 0; i < list.size(); i++) {

			Usuario u = list.get(i);

			if (u.getEmail().equals(user.getEmail())) {
				return true;
			}
		}

		return false;
	}

	private Usuario extrairDadosFormulario(HttpServletRequest request) {
		String nome = request.getParameter("nomeUsuario");
		
		int dia = Integer.parseInt(request.getParameter("dataNascimentoUsuario").split("-")[2]);
		int mes = Integer.parseInt(request.getParameter("dataNascimentoUsuario").split("-")[1]);
		int ano = Integer.parseInt(request.getParameter("dataNascimentoUsuario").split("-")[0]);

		Data dataNascimento = new Data(dia, mes, ano);

		String email = request.getParameter("emailUsuario");
		String senha = request.getParameter("senhaUsuario");

		return new Usuario(nome, email, senha, dataNascimento);
	}

}
