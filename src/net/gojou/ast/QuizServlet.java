package net.gojou.ast;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gojou.ast.fields.Field;
import net.gojou.ast.forms.Form;
import net.gojou.ast.util.Quiz;
import net.gojou.ast.util.SessionAttributes;

public class QuizServlet extends HttpServlet implements Serializable {


	private static final long serialVersionUID = 1L;
	private HttpSession session;

	private HttpServletRequest req;
	private HttpServletResponse resp;

	private Quiz quiz;
	private Form form;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.initSession(request, response);
	}

	private void initSession(HttpServletRequest request,
			HttpServletResponse response) {
		this.req = request;
		this.resp = response;
		this.session = this.req.getSession();
		

		session.removeAttribute(SessionAttributes.ANSWERS);
		Boolean answers = false;
		session.setAttribute(SessionAttributes.ANSWERS, answers);
		
		
		Object q_object = session.getAttribute(SessionAttributes.QUIZ);
		Object f_object = session.getAttribute(SessionAttributes.INPUTFORM);
		
		if ((q_object == null) || !(q_object instanceof Quiz)){
//			C.c(this.getClass().getSimpleName() + ": Quiz is null");
			this.sendToQuizBuilder();
		}
		
		if ((f_object == null) || !(f_object instanceof Form)){
//			C.c(this.getClass().getSimpleName() + ": Form is null or bad");
			this.sendToQuizBuilder();
		}
		
		quiz = (Quiz) q_object;
		form = (Form) f_object;
		
		


		@SuppressWarnings("unchecked")
		Set<String> params = new HashSet<String>(Collections.list(req.getParameterNames()));
		
		if (!params.isEmpty()){
			quiz.clear();
			for(Field f: form.getFields()){
//				C.o(this.getClass().getSimpleName() + " -- field: "+ f.getName());

				String p = req.getParameter(f.getName());
				f.setEntry(p);
				f.setValue(p);
//				C.c(" === " + f.getValue().toString());
			}
			
			if (form.isComplete()){
				for (Field f : form.getFields()){
					quiz.setQuizParameter(f.getName(), f.getValueString());
				}

				
			}
			else {
				this.sendToQuizBuilder();
			}

		}
		if (quiz.isComplete()){
			sendToQuiz();
		}
		
		else if (form.isComplete()) {
			quiz.populateQuiz();
			sendToQuiz();
		}
		
		else {
			sendToQuizBuilder();
		}


	}

	private void sendToQuiz(){
		String nextJSP = "/pages/Quiz.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextJSP);
		try {
			rd.forward(this.req, this.resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void sendToQuizBuilder(){
//		C.c(this.getClass().getSimpleName()+": reached sendToQuizBuilder");
		try {
			resp.sendRedirect("/quizbuilder");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		
	}
}
