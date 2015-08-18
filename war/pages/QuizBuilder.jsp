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
<link type="text/css" rel="stylesheet" href="ast.css">
<title>Quiz Builder</title>
<body>
	<h1>Quiz Parameters</h1>
	<h2></h2>
	<p>
		<jsp:include page="/pages/nav.jsp" />
	</p>
		<form action="quiz" method="post">
		<table>
		
			<c:forEach items="${form.fields}" var="field" varStatus="loop">
				<tr><td>
				<c:out value="${field.html }" default="Missing field descripton" escapeXml="false" />
				<c:if test="${not empty field.validationNote }">
				<div class="errorNote"><c:out value="${field.validationNote }" /></div></c:if>
				</td></tr>
			</c:forEach>
		
		</table>
				<p><input type="submit" value="Build Quiz!" /></p>

	</form>
	
	
</body>
</html>