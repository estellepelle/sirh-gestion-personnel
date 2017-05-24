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
	<h1>Activites depuis le demarrage de l'application</h1>
	<!-- Liste des noms -->
	
	<table class="table table-striped">
		<tr>
			<th>Date-Heure</th>
			<th>Libelle</th>
			
		</tr>
		
		<c:forEach var="activites" items="${activites}"> 
				<tr>
					<td>${activites.dateHeure }</td>
					<td>${activites.matricule}</td>
				</tr>
				   
			</c:forEach>
	</table>
	
		
			
			
			
	
</body>
</html>