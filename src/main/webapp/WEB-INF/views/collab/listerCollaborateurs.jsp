<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
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
	<h1>Les collaborateurs</h1>
	
	<br>
	<br>
	<br>


	<br>
	<br>
	
	<form class="form-horizontal">
	<fieldset>

			<!-- Form Name -->
			<legend>Recherche</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="searchNomPrenom">Rechercher
					un nom ou un prénom qui commence par: </label>
				<div class="col-md-2">
					<input id="searchNomPrenom" name="searchNomPrenom" type="text"
						placeholder="" class="form-control input-md">

				</div>
			</div>
			
				<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="depSearch">Filtrer
					par département :</label>
				<div class="col-md-2">
					<select id="depSearch" name="depSearch" class="form-control">

						<option value="0">Tous</option>

						<c:forEach var="dept" items="${ departements }">

							<option value="${dept.id}">${dept.nom}</option>

						</c:forEach>

					</select>
				</div>
			</div>
			
			<!-- Multiple Checkboxes (inline) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="checkboxes">Voir
					les collaborateurs désactivé :</label>
				<div class="col-md-4">
					<label class="checkbox-inline" for="checkboxes-0"> <input
						type="checkbox" name="checkboxes" id="checkboxes-0" value="1">

					</label>
				</div>
			</div>
			
			
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="search"></label>
				<div class="col-md-4">
					<button id="search" name="search" class="btn btn-primary">Rechercher</button>
				</div>
			</div>
			
	</fieldset>
	</form>
	
	<br>
	<br>
	<br>

	<a href="nouveau" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user"></span> nouveau</a>
	<br>
	<br>
	<h3>Liste des collaborateur :</h3>
	
	<br>
	<div class="jumbotron row ">

		<c:forEach var="collab" items="${collaborateur }">

			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">

				<ul>


					<li>Matricule : ${ collab.matricule } <br> Nom : ${ collab.nom }<br>
						Prenom : ${ collab.prenom }<br> Date de Naissance : ${ collab.dateNaissance }<br>
						Adresse : ${ collab.adresse }<br> Numero de séurité sociale :
						${ collab.numSecSoc }<br> Date de création : ${ collab.dateHeureCreation }<br>
						Email professionel : ${ collab.emailPro }<br> actif ? : ${ collab.actif }<br>
						<br> <br></li>
						
					<a href="editer" class="btn btn-xs btn-warning pull-right"><span
						class="glyphicon glyphicon-pencil"></span> Modifier</a>
				</ul>

			</div>

		</c:forEach>

	</div>
</body>
</html>