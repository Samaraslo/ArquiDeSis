package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CursoInfo;
import to.CursoInfoTO;

public class VisualizarCursoInfo implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
CursoInfoTO infoTO = new CursoInfoTO();
		
		String pId  = request.getParameter("id");
		infoTO.setNome(request.getParameter("nome"));
		infoTO.setDataInicio(request.getParameter("dataInicio"));
		infoTO.setDataTermino(request.getParameter("dataTermino"));
		infoTO.setHorario(request.getParameter("horario"));
		infoTO.setNumeroVagas(request.getParameter("numVagas"));
		infoTO.setValor(request.getParameter("valor"));
		infoTO.setDescricaoSoft(request.getParameter("descSoftware"));
		infoTO.setNumeroLab(request.getParameter("numeroLab"));
		infoTO.setDisponibilidade(request.getParameter("disponibilidade"));

		int id = -1;
		try {
			id = Integer.parseInt(pId);
			infoTO.setId(id);

		} catch (NumberFormatException e) {

		}

		CursoInfo info = new CursoInfo(infoTO);
		RequestDispatcher view = null;
				
		info.carregar();
		request.setAttribute("info", info.getTO());
		view = request.getRequestDispatcher("VisualizarCursoInfo.jsp");		
		
		view.forward(request, response);

		

	}


}
