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


@WebServlet("/atualiza")
public class Atualiza extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			               HttpServletResponse response)
			               throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("ID: <input type='number' name='id'><br>");
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("Nascimento: <input type='date' name='nascimento'><br>");
		out.println("Altura: <input type='number' name='altura' step='0.01'><br>");
		out.println("Passaporte: <input type='text' name='passaporte'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}

	protected void doPost(HttpServletRequest request,
			                HttpServletResponse response)
			                throws ServletException, IOException {
		DAO dao = new DAO();		
		Pessoas pessoa = new Pessoas();

		pessoa.setId(Integer.valueOf(request.getParameter("id")));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setAltura(Double.valueOf(request.getParameter("altura")));
		pessoa.setPassaporte(request.getParameter("passaporte"));
		
		String nascimento = request.getParameter("nascimento");
		try {
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			pessoa.setNascimento(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dao.altera(pessoa);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("atualizado" + pessoa.getNome());
		out.println("</body></html>");
		
		dao.close();
	}
}
