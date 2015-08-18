<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="/">Home</a><c:if test="${not empty quiz.problems}">&nbsp;-&nbsp;
<a href="/quizbuilder">New Quiz</a>&nbsp;-&nbsp;
<a href="/quiz">Show Quiz</a>&nbsp;--&nbsp;
<a href="/quiz/answers">Show Quiz with Answers</a></c:if>
