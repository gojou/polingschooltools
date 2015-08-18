package net.gojou.ast;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gojou.ast.forms.Form;
import net.gojou.ast.forms.QuizForm;
// import net.gojou.ast.util.C;
import net.gojou.ast.util.SessionAttributes;
import net.gojou.ast.util.Quiz;


public class QuizBuilderServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private Quiz quiz;
	private Form quizForm;

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.initSession(req, resp);
	}
	
	private void initSession(HttpServletRequest req, HttpServletResponse resp){
		session = req.getSession();
		
		
		if (session.getAttribute(SessionAttributes.INPUTFORM) == null) {
			this.quizForm = new QuizForm();
			session.setAttribute(SessionAttributes.INPUTFORM, this.quizForm);
		}
		else {

			quizForm = (Form) session.getAttribute(SessionAttributes.INPUTFORM);
		
			}
		

		
		if (session.getAttribute(SessionAttributes.QUIZ) == null) {
			quiz = new Quiz();
			session.setAttribute(SessionAttributes.QUIZ, quiz);
			
		}

		String nextJSP = "/pages/QuizBuilder.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
