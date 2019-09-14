package br.com.egr.banco.control;

import java.io.IOException;

import br.com.egr.banco.control.HttpServletRequest;
import br.com.egr.banco.control.HttpServletResponse;
import br.com.egr.banco.control.ServletException;

public interface Servidor {
	String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
