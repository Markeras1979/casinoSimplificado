# casinoSimplificado
technical proof

	To execute the app:

	-Import the maven project into your IDE (Import -> Existing Maven Projects -for eclipse-)
	-Execute a maven build (clean install)
	-If pom.xml is giving you some problem, execute a Maven Update or a project clean
	-Run As -> Spring Boot App
	-open your browser and go to the url http://localhost:8080/enterScreen
	-For the input Jugador introduce one of the two inserted to the embedded database in the table "jugador", in the field alias : file src/main/resources/data.sql
	-Follow the steps
	
	Technical considerations:
	
	-I've implemented a spring boot web application which contains a few very simple rest controllers who could act like services for external apps to get data for gambling games. The rules of the 2 games i've implemented (ruleta and slot) do not pretend to be like the actual ones, they are just a very simple simulation. I've implemented just these 2 though, as anybody can check, I've also implemented the  basic class and data structure for the other 3 required, they just lack the implementation of the game rules in the package juegosAPI, intended to implementate the business code.
	-I've choosen a web architecture with rest services because i've thought that this solution could show 2 sides of the coin: the rest services can simulate the behaviour of a microservices architecture, with several controllers/services waiting for http petitions of other providers, while the web part (jsp and their controllers) shows the interactive part that SpringBoot provides with their MVC architecture.
	-I've also chosen to store the incomes and outcomes of the application in an embedded HSQLDB, just to make use of Spring Data, another module of Spring Framework
	-The project could maybe be better modularized by dividing the data logic (dao and repository packages), the business logic (services) and the web logic into three modular maven projects with a parent pom.xml which would include them as modules.
	
	Sorry for the brick :)
