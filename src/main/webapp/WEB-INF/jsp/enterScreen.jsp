<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Screen</title>
<script>
	function loadInfo(){
		//console.debug("value: "+document.getElementsByName("proveedorInput")[0].value);
		console.debug("value: "+document.getElementById("proveedorInput").value);
		console.debug("value: "+document.getElementById("jugadorInput").value);
	}
</script>
</head>
<body>
<form method="post" action="chooseGame">
<div style="margin: 10px;">
	<label for="jugadorInput">Jugador</label>
	<input id="jugadorInput" type="text" value="" name="jugadorInput" placeholder="Enter Player Nick">
</div>
<div style="margin: 10px;">
	<label for="proveedorInput">Proveedor</label>
	<select id="proveedorInput" type="text" name="proveedorInput">
		<c:forEach items="${proveedores}" var="proveedor">
			<option value="${proveedor.id}">${proveedor.name}</option>
		</c:forEach>
	</select>
</div>
<!-- <div style="margin: 10px;"><button onclick="loadInfo()">Submit</button></div> -->
<div style="margin: 10px;"><input type="submit" value="Submit" /></div>
</form>
</body>
</html>