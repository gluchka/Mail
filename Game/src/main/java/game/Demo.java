package game;

import factory.Factory;

public class Demo {

	public static void main(String[] args) {
		
		Factory.chooseParser("db");
		GameMain game = new GameMain();
		game.start();
	
	}
	
}
