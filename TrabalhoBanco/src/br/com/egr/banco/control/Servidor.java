package br.com.egr.banco.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface Servidor {
	String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
