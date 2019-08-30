package br.com.gustavofaquim.alunojsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gustavofaquim.alunojsp.model.Aluno;

@WebServlet("/alunoCadastro")
public class AlunoCadastro extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String idad = req.getParameter("idade");
		int idade = Integer.parseInt(idad);
		
		Aluno a = new Aluno();
		a.setNome(nome);
		a.setIdade(idade);
		
		
		
		
	}
}
