<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex">
<link type="text/css" rel="stylesheet" href="ast.css">
<link type="text/css" rel="stylesheet" href="astforms.css">
<title>Quiz Builder</title>
</head>
<body>
	<h1>Quiz Parameters</h1>

	<div class="navigation">
		<jsp:include page="/pages/nav.jsp" />
	</div>
		<form action="quiz" method="post">
		
			
			<c:forEach items="${form.fields}" var="field" varStatus="loop">
			<div class="formfield">
				
				<c:out value="${field.html }" default="Missing field descripton" escapeXml="false" />
				<c:if test="${not empty field.validationNote }">
				<div class="errorNote"><c:out value="${field.validationNote }" /></div></c:if>
				
				</div>
			</c:forEach>
		
		
				<button type="submit" name = "submit" value="Build Quiz!" />Build it</button>
	</form>
	
	
</body>
</html>