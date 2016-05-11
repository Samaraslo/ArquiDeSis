package controller;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import to.AlunoTO;

@WebServlet("/ManterAluno.do")
public class ManterAlunosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao 		= request.getParameter("acao");
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
		
		if (pAcao.equals("Criar")) {
			aluno.incluir();
			ArrayList<AlunoTO> lista = new ArrayList<>();
			lista.add(aluno.getTO());
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarAlunos.jsp");
		} else if (pAcao.equals("Excluir")) {
			aluno.excluir();
			ArrayList<AlunoTO> lista = (ArrayList<AlunoTO>)session.getAttribute("lista");
			lista.remove(busca(aluno, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarAlunos.jsp");			
		} else if (pAcao.equals("Alterar")) {
			aluno.atualizar();
			ArrayList<AlunoTO> lista = (ArrayList<AlunoTO>)session.getAttribute("lista");
			int pos = busca(aluno, lista);
			lista.remove(pos);
			lista.add(pos, aluno.getTO());
			session.setAttribute("lista", lista);
			request.setAttribute("cliente", aluno.getTO());
			view = request.getRequestDispatcher("VisualizarAluno.jsp");			
		} else if (pAcao.equals("Visualizar")) {
			aluno.carregar();
			request.setAttribute("cliente", aluno.getTO());
			view = request.getRequestDispatcher("VisualizarAluno.jsp");		
		} else if (pAcao.equals("Editar")) {
			aluno.carregar();
			request.setAttribute("cliente", aluno.getTO());
			view = request.getRequestDispatcher("AlterarAluno.jsp");		
		}
		
		view.forward(request, response);

		

	}
	
	public int busca(Aluno aluno, ArrayList<AlunoTO> lista) {
		AlunoTO to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getCpf() == aluno.getCpf()){
				return i;
			}
		}
		return -1;
	}

}
