package command;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;


public class EditarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODString pAcao 		= request.getParameter("acao");
		String pId 			= request.getParameter("id");
		String pNome 		= request.getParameter("nome");
		String pEndereco 	= request.getParameter("endereco");
		String pTelefone 	= request.getParameter("telefone");
		String pCPF 		= request.getParameter("cpf");
		String pEmail 		= request.getParameter("email");
		String pRG 			= request.getParameter("rg");
		String pLogin 		= request.getParameter("login");
		String pSenha 		= request.getParameter("senha");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Aluno aluno = new Aluno(id, pNome, pEndereco, pTelefone, pCPF, pRG, pEmail, pLogin, pSenha );
		RequestDispatcher view = null;


			aluno.carregar();
			request.setAttribute("aluno", aluno.getTO());
			view = request.getRequestDispatcher("AlterarAluno.jsp");		
		
		
		view.forward(request, response);

	}

}
