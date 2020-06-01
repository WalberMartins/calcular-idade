package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/calcular-idade.html")
public class Filtro implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest request2 = (HttpServletRequest) request;
			HttpServletResponse response2 = (HttpServletResponse) response;
			
			if(request2.getSession(false) == null)
				response2.sendRedirect("usuario-invalido.html");
			
			chain.doFilter(request, response);
		
	}

}
