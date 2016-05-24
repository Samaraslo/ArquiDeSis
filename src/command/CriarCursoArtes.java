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

public class CriarCursoArtes implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId 				= request.getParameter("id");
		String pNome 			= request.getParameter("nome");
		String pDataInicio 		= request.getParameter("dataInicio");
		String pDataTermino		= request.getParameter("dataTermino");
		String pHorario 		= request.getParameter("horario");
		String pNumVagas 		= request.getParameter("numVagas");
		String pValor 			= request.getParameter("valor");
		String pDescMaterial 	= request.getParameter("descMaterial");
		String pNomeLivros 		= request.getParameter("livrosUtilizados");
		String pDisponibilidade	= request.getParameter("disponibilidade");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		CursoArtes artes = new CursoArtes(id, pNome, pDataInicio, pDataTermino, pHorario, pNumVagas, pValor, pDescMaterial, pNomeLivros, pDisponibilidade );
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		artes.incluir();
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		lista.add(artes.getTO());
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarCursoArtes.jsp");

		
		view.forward(request, response);

		

	}
	

}
