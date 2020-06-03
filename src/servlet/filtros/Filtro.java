package servlet.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/calcular-idade.html", "/menu-principal", 
						  "/resposta.jsp", "/Resultado.jsp", "/Editar.jsp"})
public class Filtro implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest request2 = (HttpServletRequest) request;
			HttpServletResponse response2 = (HttpServletResponse) response;
			
			if(request2.getSession(false) == null)
				response2.sendRedirect("acesso-negado.html");
			else
				chain.doFilter(request, response);
	}

}
