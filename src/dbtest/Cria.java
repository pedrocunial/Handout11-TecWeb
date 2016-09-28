package dbtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cria")
public class Cria extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
						 throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("Nascimento: <input type='date' name='nascimento'><br>");
		out.println("Altura: <input type='number' name='altura' step='0.01'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
			throws ServletException, IOException {

		DAO dao = new DAO();

		Pessoas pessoa = new Pessoas();
		pessoa.setNome(request.getParameter("nome"));   
		pessoa.setAltura(Double.valueOf(request.getParameter("altura")));

		String nascimento = request.getParameter("nascimento");
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		pessoa.setNascimento(dataNascimento);
		
		dao.adiciona(pessoa);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("adicionado" + pessoa.getNome());
		out.println("</body></html>");
		
		dao.close();
	} 
}


