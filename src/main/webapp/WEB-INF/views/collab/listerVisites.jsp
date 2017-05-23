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
	
	<table class="table table-striped">
		<tr>
			<th>Chemin</th>
			<th>Nombre de visites</th>
			<th>Min</th>
			<th>Max</th>
			<th>Moyenne</th>
		</tr>
		
		<c:forEach var="visite" items="${visites}"> 
				<tr>
					<td>${visite.chemin}</td>
					<td>${visite.nbVisites}</td>
					<td>${visite.minExecution}</td>
					<td>${visite.maxExecution}</td>
					<td>${visite.moyExecution}</td>
				</tr>
				   
			</c:forEach>
	</table>
	
		
			
			
			
	
</body>
</html>