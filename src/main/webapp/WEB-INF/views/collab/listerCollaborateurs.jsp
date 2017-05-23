<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	<!-- Liste des noms -->
	<ul>
		<%
			List<Collaborateur> collaborateur = (List<Collaborateur>) request.getAttribute("collaborateur");
			for (Collaborateur nom : collaborateur) {
		%>
		<li><%=nom.getNom()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>