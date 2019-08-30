package br.com.gustavofaquim.alunojsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gustavofaquim.alunojsp.dao.CidadeDAO;

@WebServlet("/cidadeLista")
public class CidadeLista extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.listar();
		
		// Estou aqui! Fazendo a listagem
	}
}
