package br.com.egr.banco.servlet;

import java.io.IOException;



import br.com.egr.banco.control.Servidor;




//@WebServlet("/control")
public class ContrrollerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("x");
		String nomeClasse = "br.com.egr.banco.controller" + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			
			Servidor servidor  = (Servidor) classe.getDeclaredConstructor().newInstance();
			
			String pagina = servidor.executa(req, resp);
			
			req.getResquestDispatcher(pagina).forward(req,resp);
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}

	
