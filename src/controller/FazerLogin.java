package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet implementation class FazerLogin
 */
@WebServlet("/login.do")
public class FazerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");

		Usuario usuario = new Usuario(nome, senha);
		HttpSession session = request.getSession();
		if(usuario.validar()){
			session.setAttribute("logado", usuario.getTO());
			System.out.println("Logou "+usuario.getTO());
		} else {
			System.out.println("Não Logou "+usuario.getTO());
			throw new ServletException("Usuário/Senha inválidos");
		}
		response.sendRedirect("index.jsp");		
	}

}
