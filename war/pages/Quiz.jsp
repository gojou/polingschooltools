<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex">
<link type="text/css" rel="stylesheet" href="/ast.css">
<link type="text/css" rel="stylesheet" href="/astquiz.css">
<title>Quiz</title>
<body>
	<h1>Quiz</h1>
	<p><jsp:include page="nav.jsp" /></p>
	<table>
		<tr>
			<c:forEach items="${quiz.problems}" var="Problem" varStatus="loop">
				<c:if test="${not loop.first and loop.index % 5 == 0}">
		</tr>
		<tr>
			</c:if>
			<td><div class="cell">
					<div class="problem">
						<div class="operator">${Problem.operatorString}</div>
						<div class="terms">
							<div class="term1">${Problem.term1String}</div>
							<div class="term2">${Problem.term2String}</div>
						</div>
					</div>
					<div class="solution">
						<c:if test="${answers}">${Problem.solutionString}</c:if>
						<c:if test="${not answers}">&nbsp;</c:if>
					</div>
					</td>
			</c:forEach>
		</tr>
	</table>


</body>
</html>