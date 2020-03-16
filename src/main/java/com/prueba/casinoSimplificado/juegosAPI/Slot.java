package com.prueba.casinoSimplificado.juegosAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Slot {
	
	private List<String> cards = Arrays.asList("pear","apple","star");
	private HashMap<String, Integer> prizes = new HashMap<String, Integer>()
	{{
	     put("pear", 1);
	     put("apple", 2);
	     put("star", 5);
	}};
	
	public HashMap<Integer,List<String>> getJugada(String probabilidad) {
		
		 HashMap<Integer,List<String>> resultAndPrize = new HashMap<Integer, List<String>>();
		 Integer prize = 0;
		 List<String> result = new ArrayList<String>();
		 for (int i = 0; i < 3; i++) {	
		 result.add(cards.get((int) (Math.random()*3)));
		 }
		 checkProbabilidad(result, probabilidad);
		 prize = checkPrize(result);
		 return resultAndPrize;
	}
	
	public void checkProbabilidad(List<String> result, String probabilidad) {
		if(probabilidad == "33%") {
			//If probability is 1/3 and 2 cards are equal, then another chance is given
			if((result.get(0).equals(result.get(1))) && (!result.get(0).equals(result.get(2)))) {
				result.set(2, cards.get((int) (Math.random()*3)));
			}
			
			if((result.get(0).equals(result.get(2))) && (!result.get(0).equals(result.get(1)))) {
				result.set(1, cards.get((int) (Math.random()*3)));
			}
			
			if((result.get(2).equals(result.get(1))) && (!result.get(0).equals(result.get(2)))) {
				result.set(0, cards.get((int) (Math.random()*3)));
			}
		}//If probability is higher, more chances should be given accordingly to percentage
	}
	
	public Integer checkPrize( List<String> result) {
		if(result.get(0).equals(result.get(1)) && result.get(1).equals(result.get(2))) {

				 return prizes.get(result.get(0));
		}
		return 0;
	}
	
}
