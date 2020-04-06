package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculaIdade")
public class CalculaIdade extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataNascimento = Calendar.getInstance();
		
		try {
			dataNascimento.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("dataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int idade = getIdade(dataAtual, dataNascimento);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Sua idade é "+idade+" anos.<p>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	private int getIdade(Calendar dataAtual, Calendar dataNascimento) {
		int idade = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
		
		if(dataAtual.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
			idade--;
		}
		else if(dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
			idade--;
		}
		
		return idade;
	}

}