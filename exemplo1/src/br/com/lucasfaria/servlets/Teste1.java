package br.com.lucasfaria.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Teste1 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeiro Teste</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Conteúdo do primeiro teste</h3>");
		out.println("</body>");
		out.println("</html>");
	}
}
