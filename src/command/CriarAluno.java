package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import to.AlunoTO;

public class CriarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
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
			HttpSession session = request.getSession();
			
				aluno.incluir();
				ArrayList<AlunoTO> lista = new ArrayList<>();
				lista.add(aluno.getTO());
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarAlunos.jsp");
				view.forward(request, response);
	}

}
