package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import factory.Factory;

public class GameMain  extends Players{


	public static char lastLetter;

	public static char firstWord() {
		Random first = new Random();
		int chooseCity = first.nextInt(Factory.cities.size());
		System.out.println(Factory.cities.get(chooseCity));
		String word = String.valueOf(Factory.cities.get(chooseCity));
		delete(word);
		lastLetter = Players.checkLastLetter(word);	
		return lastLetter;
	}
	
	public void start() {
		
		User user = new User();
		Mashine mash = new Mashine();
		
		firstWord();
		
		
		while(Factory.cities.size()!=0 && (checkNextWord(lastLetter))){
			System.out.println(lastLetter);

			lastLetter=user.writeWord(Factory.cities, lastLetter);	
			lastLetter=mash.writeWord(Factory.cities, lastLetter);
		}
		
		System.out.println("GAME OVER!");
	}	
	
	@Override
	public char writeWord(List city, char last) {
		return last;
	}

	

	
	
	
	
	
	
}
