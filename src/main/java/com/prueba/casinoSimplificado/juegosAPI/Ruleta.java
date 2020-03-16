package com.prueba.casinoSimplificado.juegosAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class Ruleta {
	
	private List<Integer> numbers =  Arrays.asList( 1,2,3,4,5,6,7,8,9,10);
	private List<String> colors = Arrays.asList( "red", "black");
	
	public HashMap<Integer,String> getJugada(Integer number, String color,String probabilidad) {		
		HashMap<Integer,String> resultado = new HashMap<Integer, String>();		
		if(probabilidad.equals("10%")) {
			//Random r = new Random();
			Integer numeroResult = (int) (Math.random()*10);
			String colorResult = colors.get((int) (Math.random()*2));
			resultado.put(numeroResult, colorResult);
		}
		
		return resultado;
	}
}
