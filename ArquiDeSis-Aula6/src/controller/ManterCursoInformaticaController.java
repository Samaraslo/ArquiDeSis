package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAluno;
import model.ModelInformatica;
import to.InformaticaTO;

/**
 * Servlet implementation class ManterCursoController
 */
@WebServlet("/manter_curso_informatica.do")
public class ManterCursoInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();

		InformaticaTO infoTO = new InformaticaTO();
		
		infoTO.setIdCurso(request.getParameter("codigo"));
		infoTO.setNomeCurso(request.getParameter("nome"));
		infoTO.setDataInicio(request.getParameter("dataIni")); // nome do parametro do formulário 
		infoTO.setDataTermino(request.getParameter("dataFim"));
		infoTO.setHorario(request.getParameter("horario")); // nome do parametro do formulário 
		infoTO.setNumeroVagas(request.getParameter("numVagas"));
		infoTO.setValorCurso(request.getParameter("valor")); // nome do parametro do formulário 
		infoTO.setNumeroLab(request.getParameter("numLab"));
		infoTO.setRegistroSoft(request.getParameter("registroSoft"));
		infoTO.setDisponibilidade(request.getParameter("disp"));
		
		String pAcao = request.getParameter("acao");

		ModelInformatica manterInfo = new ModelInformatica(infoTO);

		RequestDispatcher view = null;
		
		if(pAcao.equals("Cadastrar")){
			try {
				manterInfo.cadastrar();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			out.println( "Curso cadastrado com sucesso");
		}
	}

}
