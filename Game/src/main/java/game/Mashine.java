package game;

import java.util.Iterator;
import java.util.List;

import factory.Factory;

public class Mashine extends Players{

	@Override
	public char writeWord(List city,char last) {
	
	String mashWord = getFirstWord(last);
	if (mashWord != null){
	delete(mashWord);
	GameMain.lastLetter = Players.checkLastLetter(mashWord);
	System.out.println(mashWord);
	return GameMain.lastLetter;
	}
	else {city.clear();
	System.out.println("User win!");
	return (char) -1;}
			}


	public static String getFirstWord(char last){
		String word = null;
		Iterator<String> itr = Factory.cities.iterator();
		while (itr.hasNext()) {
			String cityItr = (String) itr.next();
			if (cityItr.charAt(0) == last)
				return cityItr;
		}		
		return null;
		
	}


}
