package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelInformatica;

/**
 * Servlet implementation class Manter_Curso
 */
@WebServlet("/Manter_Curso.do")
public class ManterCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nomeCurso");
		String pDtInicio = request.getParameter("dataInicio");
		String pDtFim = request.getParameter("dataTermino");
		String pHorario = request.getParameter("horarioPrevisto");
		String valor = request.getParameter("valorCurso"); 
		String NumVagas = request.getParameter("numeroDeVagas");
		String NumLab = request.getParameter("numeroDoLaboratorio");
		String pRegSoft = request.getParameter("descricaoSoftware");
		String pCursoDisp = request.getParameter("disponivel");
		
		double pValor = Double.parseDouble(valor);
		int pNumVagas = Integer.parseInt(NumVagas);
		int pNumLab = Integer.parseInt(NumVagas);
		
		String pAcao = request.getParameter("acao");
		
		ModelInformatica mdInformatica = new ModelInformatica(pNome,pDtInicio,pDtFim,pHorario,pNumVagas,pValor,pRegSoft,pNumLab,pCursoDisp);
		
		
		mdInformatica.criar();
		mdInformatica.carregar();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
	}

}
