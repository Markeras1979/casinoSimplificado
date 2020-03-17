package com.prueba.casinoSimplificado.juegosAPI;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.dto.RuletaDTO;

@Service
public class Ruleta {
	
	private List<Integer> numbers =  Arrays.asList( 1,2,3,4,5,6,7,8,9,10);
	private List<String> colors = Arrays.asList( "red", "black");
	
	public RuletaDTO getJugada(Integer number, String color,String probabilidad) {		
		
		RuletaDTO resultado = new RuletaDTO();
		if(probabilidad.equals("10%")) {
			Integer numeroResult = numbers.get((int) (Math.random()*10));
			String colorResult = colors.get((int) (Math.random()*2));
			resultado.setColor(colorResult);
			resultado.setNumero(numeroResult);
			resultado.setWin(numeroResult.equals(number) && colorResult.equals(color));
		}
		
		return resultado;
	}
}
