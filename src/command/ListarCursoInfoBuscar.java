package command;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CursoInfo;
import to.CursoInfoTO;

public class ListarCursoInfoBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		CursoInfo info = new CursoInfo();
		ArrayList<CursoInfoTO> lista = null;
		
		HttpSession session = request.getSession();
		
			if (chave != null && chave.length() > 0) {
				lista = info.listarCursoInfo(chave);
			} else {
			 	lista = info.listarCursoInfo();
			}
			session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarCursoInfo.jsp");
		dispatcher.forward(request, response);
	
	}
	
}
