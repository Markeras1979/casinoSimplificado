<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Play!</title>
<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script>
function play(){
	$.ajax({
		type : "POST",
		contentType: "application/json",
		url : "/jugadaRuleta",
		dataType: 'json',
		data : JSON.stringify({numero : $("select#numero").val(),color : $("select#color").val()}),
		success : function(response) {
			console.log(response);
			responseJson = JSON.stringify(response);
			numero = JSON.stringify(response["numero"]);
			console.log(numero);
			if(response["win"] == true){
				$("#ruletaResult").empty();
				$("<p>Felicidades, has ganado!</p>").appendTo("#ruletaResult");
			}else{
				if(response["partidaAcabada"] == true){
					$("#ruletaResult").empty();
					$("<p>Tu tiempo de sesión ha expirado</p>").appendTo("#ruletaResult");
				}else{
					$("#ruletaResult").empty();
					$("<p>Lo sentimos, has perdido. El resultado de la tirada es:"+response["numero"]+" "+response["color"]+"</p>").appendTo("#ruletaResult");
				}			
			}
			
		},
		error : function(response) {

		}
	});
}

</script>
</head>
<body>
	<div style="margin: 10px;">
		Hola ${nick}, tienes ${tiempoJuego} segundo(s) para jugar a ${juegoSelected.nombre}
	</div>
	<c:if test="${juegoSelected.nombre == 'RULETA'}">
		<div style="margin: 10px;">
			<select id="numero" name="numero">
				<c:forEach var = "i" begin = "1" end = "10">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
		</div>
		<div style="margin: 10px;">
			<select id="color" name="color">
				<option value="black">Black</option>
				<option value="red">Red</option>
			</select>
		</div>
		<button onclick="play()">Play</button>
		
		<div id="ruletaResult" style="margin: 10px;">
		
		</div>
	</c:if>
	<c:if test="${juegoSelected.nombre == 'SLOT'} ">
	</c:if>
</body>
</html>