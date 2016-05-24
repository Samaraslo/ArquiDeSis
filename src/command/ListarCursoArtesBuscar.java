package command;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CursoArtes;
import to.CursoArtesTO;

public class ListarCursoArtesBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		CursoArtes artes = new CursoArtes();
		ArrayList<CursoArtesTO> lista = null;
		HttpSession session = request.getSession();
		
			if (chave != null && chave.length() > 0) {
				lista = artes.listarCursoArtes(chave);
			} else {
			 	lista = artes.listarCursoArtes();
			}
			session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarCursoArtes.jsp");
		dispatcher.forward(request, response);
		
	}

}