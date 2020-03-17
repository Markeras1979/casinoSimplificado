package com.prueba.casinoSimplificado.juegosAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.dto.SlotDTO;

@Service
public class Slot {
	
	private List<String> slots = Arrays.asList("pear","apple","star");
	private HashMap<String, Integer> prizes = new HashMap<String, Integer>()
	{{
	     put("pear", 1);
	     put("apple", 2);
	     put("star", 5);
	}};
	
	public SlotDTO getJugada(String probabilidad) {
		
		 SlotDTO resultAndPrize = new SlotDTO();
		 Integer prize = 0;
		 List<String> result = new ArrayList<String>();

		 resultAndPrize.setSlot1(slots.get((int) (Math.random()*3)));
		 resultAndPrize.setSlot2(slots.get((int) (Math.random()*3)));
		 resultAndPrize.setSlot3(slots.get((int) (Math.random()*3)));

		 checkProbabilidad(resultAndPrize, probabilidad);
		 prize = checkPrize(resultAndPrize);
		 resultAndPrize.setPrize(prize);
		 return resultAndPrize;
	}
	
	public void checkProbabilidad(SlotDTO result, String probabilidad) {
		if(probabilidad == "33%") {
			//If probability is 1/3 and 2 slots are equal, then another chance is given
			if((result.getSlot1().equals(result.getSlot2())) && (!result.getSlot1().equals(result.getSlot3()))) {
				result.setSlot3(slots.get((int) (Math.random()*3)));
			}
			
			if((result.getSlot1().equals(result.getSlot3())) && (!result.getSlot1().equals(result.getSlot2()))) {
				result.setSlot2(slots.get((int) (Math.random()*3)));
			}
			
			if((result.getSlot3().equals(result.getSlot2())) && (!result.getSlot1().equals(result.getSlot3()))) {
				result.setSlot1(slots.get((int) (Math.random()*3)));
			}
		}//If probability is higher, more chances should be given accordingly to percentage
	}
	
	public Integer checkPrize( SlotDTO result) {
		if(result.getSlot1().equals(result.getSlot2()) && result.getSlot2().equals(result.getSlot3())) {
				 return prizes.get(result.getSlot1());
		}
		return 0;
	}
	
}
