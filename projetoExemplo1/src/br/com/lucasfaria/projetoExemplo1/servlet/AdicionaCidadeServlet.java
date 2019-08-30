package br.com.lucasfaria.projetoExemplo1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.projetoExemplo1.dao.CidadeDao;
import br.com.lucasfaria.projetoExemplo1.model.Cidade;

@WebServlet("/adicionarCidade")
//@WebServlet(name = "MinhaServlet", urlPatterns = {"/oi", "/ola"})
//se não possui "name" então o nome da Servlet é o Fully Qualified Name.
public class AdicionaCidadeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

//		busca parâmetro (enviados pelo formulário)
		String nome = req.getParameter("nome");
		String estado = req.getParameter("estado");

//		objeto contato
		Cidade cidade = new Cidade();
		cidade.setNome(nome);
		cidade.setEstado(estado);
		
//		salvar a cidade
		CidadeDao dao = new CidadeDao();
		dao.inserir(cidade);
		
//		Imprimindo a página
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Informações da Cidade</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Cidade " + cidade.getNome() + "(" + cidade.getEstado() + ")" + " adicionada com sucesso.");
		out.println("</body>");
		out.println("</html>");
	}
}
