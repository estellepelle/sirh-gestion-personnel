<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<h1>Statistiques</h1>
	<!-- Liste des noms -->
	<ul>
		
			<c:forEach var="visite" items="${visites}"> 
				<li> ${visite.chemin} ${visite.nbVisites} ${visite.minExecution} ${visite.maxExecution} ${visite.moyExecution} </li>
			</c:forEach>
			
			
	</ul>
</body>
</html>