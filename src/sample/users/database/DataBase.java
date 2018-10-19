package sample.users.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sample.users.User;

public class DataBase {

	// creates a single text file that keeps track of users account
	private static File database = new File("res/database.txt");

	public static void saveAccount(User user) {
		String data = user.getAllData();
		try {
			// allows writing to file, second paremeter appends to file
			FileWriter writer = new FileWriter(database, true);
			writer.write(data + "\n");
			System.out.println("Account saved to database.");
			writer.close();
		} catch (IOException e) {

		}
	}

	public static ArrayList<String> getDataList() {
		// stores all accounts
		ArrayList<String> accounts = new ArrayList<String>();
		try {
			// allows reading the file
			Scanner reader = new Scanner(database);
			while (reader.hasNext()) {
				accounts.add(reader.nextLine() + "\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public static boolean accountExists(String username, String password) {
		ArrayList<String> database = getDataList();
		for (int i = 0; i < database.size(); i++) {
			// username from database
			String u = database.get(i).split(":")[1];
			// password from database
			String p = database.get(i).split(":")[2];

			// Checks for matches in database 
			if (u.equals(username) && p.equals(password)) return true;
	}
		return false;
	}

}
