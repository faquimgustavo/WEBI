package br.com.egr.banco.control;

import java.io.IOException;

public class CadastroCliente implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		String endereco = req.getParameter("endereco");
		String x = req.getParameter("x");
		String tipo = req.getParameter("tipo");
		
		System.out.println(tipo);
		
		
		
		return null;
	}

}
