package command;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CursoArtes;

public class EditarCursoArtes implements Command {

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

		artes.carregar();
		request.setAttribute("artes", artes.getTO());
		view = request.getRequestDispatcher("AlterarCursoArtes.jsp");		
		
		view.forward(request, response);

		

	}

}
