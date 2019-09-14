package br.com.egr.banco.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.egr.banco.control.Servidor;




@WebServlet("/control")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("x");
		String nomeClasse = "br.com.egr.banco.control." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			
			Servidor servidor  = (Servidor) classe.getDeclaredConstructor().newInstance();
			
			String pagina = servidor.executa(req, resp);
			
			req.getRequestDispatcher(pagina).forward(req, resp);
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}

	
