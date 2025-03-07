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
	<select id="proveedorInput" name="proveedorInput">
		<c:forEach items="${proveedores}" var="proveedor" varStatus="loop">
			<c:choose>
				<c:when test="${loop.index == 0}"><option selected value="${proveedor.id}">${proveedor.name}</option></c:when>
				<c:otherwise><option value="${proveedor.id}">${proveedor.name}</option></c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</div>
<!-- <div style="margin: 10px;"><button onclick="loadInfo()">Submit</button></div> -->
<div style="margin: 10px;"><input type="submit" value="Submit"/></div>
</form>
</body>
</html>