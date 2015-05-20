package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import factory.Factory;

public class User extends Players {
	private static final Logger LOGGER_INFO = Logger.getLogger(User.class);
	private static final Logger LOGGER_ERR = Logger.getLogger(User.class);

	protected static int countOfUsers = 0;
	protected String usersName = "User";
	static List<User> users = new ArrayList<User>(countOfUsers);

	public User(String name) {
		usersName = usersName + name;
	}

	public User(int count) {
		countOfUsers = count;
	}

	public void addUsers() {
		for (int i = 0; i < countOfUsers;)
			users.add(new User("" + ++i));
	}

	@Override
	public void writeWord() {
		System.out.println(usersName + ":");
		LOGGER_INFO.info("��� ������!");
		String check;
		String userWord = null;
		do {
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
				userWord = reader.readLine();
			} catch (IOException e) {
				LOGGER_ERR.error("�� ���������� ���� �� �������");
				System.err.print("�� ���������� ���� �� �������");
			}
			if (userWord.equals("exit")) {
				break;
			}

			check = checkInList(userWord);
			LOGGER_INFO.info("����� ������ ��������!");
		} while (check == null);
		delete(userWord);
		GameSities.lastLetter = Players.checkLastLetter(userWord);
		System.out.println(GameSities.lastLetter + "       lastLetter");
	}

	public static String checkInList(String word) {
		if (Factory.cities.contains(word) == true
				&& word.charAt(0) == GameSities.lastLetter)
			return word;
		else {
			System.out.println("Try again!");
			LOGGER_ERR.error("��� ��������� ������, ������� �� ������ �����");
			return null;
		}
	}
}
