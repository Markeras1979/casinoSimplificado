<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Game and play</title>
<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script>

	function hideOrShowGameSelect(){
		var casinosId = document.getElementById("casinosInput").value;
		var casinosNumber = document.getElementById("casinosNumber").value;
		for(i=1;i<=casinosNumber;i++){
			if(i != casinosId){
				var juegosInputToHide = document.getElementById("juegosInput"+i);
				 juegosInputToHide.style.display = "none";
			}
		}
		var juegosInputToShow = document.getElementById("juegosInput"+casinosId);
		juegosInputToShow.style.display = "block";
	}
	
	function setJuegoSelected(input){
		 document.getElementById("juegoSelected").value =  document.getElementById(input).value;
	}
	
	function enableSubmit(id){
		console.log($(id).val());
		if($(id).val() != "" ){
			$("#submit").prop("disabled",false);
		}else{
			$("#submit").prop("disabled",true);
		}
	}
</script>
</head>
<body>
<form method="post" action="playGame">
<div style="margin: 10px;">
	<input type="hidden" id="casinosNumber" value="${casinosNumber}" >
	<label for="casinosInput">Casinos</label>
	<select id="casinosInput" onchange="hideOrShowGameSelect()" name="casinosInput">
		<option value="" selected>Choose Casino</option>
		<c:forEach items="${casinos}" var="casino">
			<option value="${casino.id}">${casino.name}</option>
		</c:forEach>
	</select>
</div>
<div style="margin: 10px;">
	<c:forEach items="${casinos}" var="casino"  varStatus="loop">
		<input type="hidden" id="juegosSize${casino.id}">		
		<div id="juegosInput${casino.id}" style="display: none;">
			<label for="juegosInputSelect${casino.id}">Juegos para ${casino.name}</label>
			<select id="juegosInputSelect${casino.id}" onchange="setJuegoSelected('juegosInputSelect${casino.id}'); enableSubmit(juegosInputSelect${casino.id});" name="juegosInput">
				<option value="" selected>Choose Game</option>
				<c:forEach items="${casino.juegos}" var="juego"  varStatus="loop">
					<option value="${juego.id}">${juego.nombre}</option>
				</c:forEach>
			</select>
		</div>
	</c:forEach>
	<input type="hidden" id="juegoSelected" name="juegoSelected">
</div>
<div style="margin: 10px;"><input id="submit" type="submit" value="Submit" disabled="true"/></div>
</form>
</body>
</html>