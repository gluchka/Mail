package game;

import java.util.List;
import java.util.Scanner;

import factory.Factory;

public class User extends Players {

	@Override
	public char writeWord(List city, char last) {
		String check;
		String userWord;
		do {
			Scanner input = new Scanner(System.in);
			userWord = input.next();
			check = checkInList(userWord, last);
		} while (check == null);
		delete(userWord);
		GameMain.lastLetter = Players.checkLastLetter(userWord);
		return GameMain.lastLetter;
	}

	public String checkInList(String word, char last) {
		if (Factory.cities.contains(word) == true && word.charAt(0) == last)
			return word;
		else {
			System.out.println("Try again!");
			return null;
		}
	}
}
