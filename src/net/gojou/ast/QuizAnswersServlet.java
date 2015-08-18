package net.gojou.ast;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gojou.ast.util.SessionAttributes;

public class QuizAnswersServlet extends HttpServlet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.initSession(request, response);
	}
	
	private void initSession(HttpServletRequest request, HttpServletResponse response){
		
		this.req = request;
		this.resp = response;
		
		session = req.getSession();
		
		if (session.getAttribute(SessionAttributes.INPUTFORM) == null){
			try {
				resp.sendRedirect("/quizbuilder");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		if (session.getAttribute(SessionAttributes.QUIZ) == null){
			try {
				resp.sendRedirect("/quizbuilder");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		session.removeAttribute(SessionAttributes.ANSWERS);
		Boolean answers = true;
		session.setAttribute(SessionAttributes.ANSWERS, answers);
		
		

		
		String nextJSP = "/pages/Quiz.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextJSP);
		try {
			rd.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


