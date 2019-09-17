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
		System.out.println("\n \n " + nomeClasse + "\n \n");
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			System.out.println("\n \n Nome da Classe: " + classe.getName() + "\n \n");
			
			Servidor servidor  = (Servidor) classe.getDeclaredConstructor().newInstance();
			System.out.println("\n \n Servidor: " + servidor.toString()  + "\n \n");
			
			String pagina = servidor.executa(req, resp);
			
			System.out.println("\n \n Pagina: " + pagina + "\n \n");
			
			req.getRequestDispatcher(pagina).forward(req, resp);
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}

	
