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
function playRuleta(){
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
		error : function(e) {

		}
	});
}

function playSlot(){
	$.ajax({
		type : "POST",
		contentType: "application/json",
		url : "/jugadaSlot",
		dataType: 'json',
		data : {},
		success : function(response) {
			console.log(response);
			responseJson = JSON.stringify(response);
			console.log(JSON.stringify(response["slot1"]));
			$("#slot1").empty();
			$("#slot2").empty();
			$("#slot3").empty();
			$("#SlotResult").empty();
			$("<p>"+JSON.stringify(response["slot1"])+"</p>").appendTo("#slot1");
			$("<p>"+JSON.stringify(response["slot2"])+"</p>").appendTo("#slot2");
			$("<p>"+JSON.stringify(response["slot3"])+"</p>").appendTo("#slot3");
			$("#credit").empty();
			$("<p>"+response["creditsAmount"]+"</p>").appendTo("#credit");
			if(response["prize"] > 0){
				$("#SlotResult").empty();
				win = JSON.stringify(response["prize"]);
				$("<p>Win!: "+win+"</p>").appendTo("#SlotResult");
			}else{
				if(JSON.stringify(response["partidaAcabada"]) == "true"){
					$("#playSlot").prop('disabled', true);
					if(JSON.stringify(response["creditsAmount"])<JSON.stringify(response["apuestaMinima"])){
						$("#SlotResult").empty();			
						$("<p>Tus créditos se agotaron</p>").appendTo("#SlotResult");
						$("#slot1").empty();
						$("#slot2").empty();
						$("#slot3").empty();
						$("<p>Game Over</p>").appendTo("#slot1");
						$("<p>Game Over</p>").appendTo("#slot2");
						$("<p>Game Over</p>").appendTo("#slot3");
					}else{
						$("#SlotResult").empty();					
						$("<p>Tu tiempo de sesión ha expirado</p>").appendTo("#SlotResult");
						$("#slot1").empty();
						$("#slot2").empty();
						$("#slot3").empty();
						$("<p>Game Over</p>").appendTo("#slot1");
						$("<p>Game Over</p>").appendTo("#slot2");
						$("<p>Game Over</p>").appendTo("#slot3");
					}
				}		
			}			
		},
		error : function(e) {

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
		<button onclick="playRuleta()">Play</button>
		
		<div id="ruletaResult" style="margin: 10px;">
		
		</div>
	</c:if>
	<c:if test="${juegoSelected.nombre == 'SLOT'}">
		<div style="margin: 10px;">
			<div id="slot1" style="border: 0.5px solid black; width: 5%;">Play!</div><div id="slot2" style="border: 0.5px solid black; width: 5%;">Play!</div><div id="slot3" style="border: 0.5px solid black; width: 5%;">Play!</div>
		</div>			
		<button id="playSlot" onclick="playSlot()">Play</button>
		<div id="SlotResult" style="margin: 10px;">
			
		</div>
		<div style="margin: 10px;">Credits: <span id="credit">${creditoInicial}</span></div>		
	</c:if>
	<div style="margin: 10px;"><a href="/enterScreen">Retorna a la página inicial</a></div>
</body>
</html>