package br.com.egr.banco.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroProduto implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idcliente = req.getParameter("idcliente");
		String produto = req.getParameter("produto");
		
		if(produto.equals("contaCorrente")) {
			
		}
		else if(produto.equals("contaPopuanca")) {
			
		}
		else if(produto.equals("Seguro")) {
			
		}
		return null;
	}

}
