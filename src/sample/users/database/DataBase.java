package sample.users.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sample.users.Organization;
import sample.users.User;
import sample.users.Volunteer;
import sample.users.events.Action;
import sample.users.events.Event;

public class Database {

	// creates a single text file for user accounts
	private static File databaseUser = new File("res/databaseUser.txt");

	// creates a single text file for events
	private static File databaseEvent = new File("res/databaseEvent.txt");

	// creates a single text file for status (follows / invites)
	private static File databaseStatus = new File("res/databaseStatus.txt");

	private static ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
	private static ArrayList<Organization> organizations = new ArrayList<Organization>();

	private static ArrayList<Event> events = new ArrayList<Event>();

	static {
		// creates objects from data found in the database
		ArrayList<String> userList = Database.getUserList();
		for (int i = 0; i < userList.size(); i++) {
			String userData = userList.get(i);
			String id = userData.split(":")[0];
			String username = userData.split(":")[1];
			String firstName = userData.split(":")[2];
			String lastName = userData.split(":")[3];
			String aboutMe = userData.split(":")[4];
			String[] interests = { userData.split(":")[5], //
					userData.split(":")[6], userData.split(":")[7] };
			String email = userData.split(":")[8];
			String address = userData.split(":")[9];
			String password = userData.split(":")[10];
			if (id.equals(User.VOLUNTEER)) {
				Volunteer volunteer = new Volunteer(User.VOLUNTEER, username, firstName, lastName, email, address,
						password);
				volunteer.setAboutMe(aboutMe);
				volunteer.setInterests(interests);
				volunteers.add(volunteer);
			} else { // ORGANIZATION
				Organization organization = new Organization(User.ORGANIZATION, username, firstName, lastName, email,
						address, password);
				organization.setAboutMe(aboutMe);
				organization.setInterests(interests);
				organizations.add(organization);
			}
		}
		
		// creates event objects from data found in the database
		ArrayList<String> eventList = getEventList();
		for (int i = 0; i < eventList.size(); i++) {
			String host = eventList.get(i).split(":")[0];
			String name = eventList.get(i).split(":")[1];
			String date = eventList.get(i).split(":")[2];
			String address = eventList.get(i).split(":")[3];
			Event event = new Event(host, name, date, address);
			event.setDescription(eventList.get(i).split(":")[4]);
			events.add(event);
		}
	}

	public static void saveAccount(User user) {
		String data = user.getUserData();
		try {
			// allows writing to file, second paremeter appends to file
			FileWriter writer = new FileWriter(databaseUser, true);
			writer.write(data + "\n");
			System.out.println("Account saved to database.");
			writer.close();
		} catch (IOException e) {

		}
	}

	public static void saveEvent(Event event) {
		String data = event.getEventData();
		try {
			// allows writing to file, second paremeter appends to file
			FileWriter writer = new FileWriter(databaseEvent, true);
			writer.write(data + "\n");
			System.out.println("Event saved to database.");
			writer.close();
		} catch (IOException e) {

		}
	}
	
	// requesting = asking, receiver = accepting/declining
	public static void saveAction(Action action, User requesting, User receiver) { 
		String data = action.name() + ":" + requesting.getUserName() + ":" + receiver.getUserName();
		try {
			// allows writing to file, second paremeter appends to file
			FileWriter writer = new FileWriter(databaseStatus, true);
			writer.write(data + "\n");
			System.out.println("Status saved to database.");
			writer.close();
		} catch (IOException e) {

		}		
	}
	
	public static void saveAction(Action action, User user, Event event) { 
		String data = action.name() + ":" + user.getUserName() + ":" + event.getName();
		try {
			// allows writing to file, second paremeter appends to file
			FileWriter writer = new FileWriter(databaseStatus, true);
			writer.write(data + "\n");
			System.out.println("Status saved to database.");
			writer.close();
		} catch (IOException e) {

		}		
	}

	private static ArrayList<String> getUserList() {
		// stores all accounts
		ArrayList<String> accounts = new ArrayList<String>();
		try {
			// allows reading the file
			Scanner reader = new Scanner(databaseUser);
			while (reader.hasNext()) {
				accounts.add(reader.nextLine());

			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	private static ArrayList<String> getEventList() {
		// stores all accounts
		ArrayList<String> events = new ArrayList<String>();
		try {
			// allows reading the file
			Scanner reader = new Scanner(databaseEvent);
			while (reader.hasNext()) {
				events.add(reader.nextLine());

			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return events;
	}
	
	public static ArrayList<String> getActionList() {
		// stores all accounts
		ArrayList<String> actions = new ArrayList<String>();
		try {
			// allows reading the file
			Scanner reader = new Scanner(databaseStatus);
			while (reader.hasNext()) {
				actions.add(reader.nextLine());

			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return actions;
	}
	
	public static boolean accountExists(String username, String password) {
		ArrayList<String> database = getUserList();
		for (int i = 0; i < database.size(); i++) {
			// username from database
			String u = database.get(i).split(":")[1];
			// password from database
			String p = database.get(i).split(":")[10];

			// Checks for matches in database
			if (u.equals(username) && p.equals(password))
				return true;
		}
		return false;
	}
	
	public static User getUser(String name, String password) {
		ArrayList<String> userList = getUserList();
		User user = null;
		for (int i = 0; i < userList.size(); i++) {			
			String userData = userList.get(i);
			String id = userData.split(":")[0];
			String u = userData.split(":")[1];
			String firstName = userData.split(":")[2];
			String lastName = userData.split(":")[3];
			String aboutMe = userData.split(":")[4];
			String[] interests = { userData.split(":")[5], //
					userData.split(":")[6], userData.split(":")[7] };
			String email = userData.split(":")[8];
			String address = userData.split(":")[9];
			String p = userData.split(":")[10];
			
			if (name.equals(u) && password.equals(p)) {
				user = new User(id, u, firstName, lastName, email, address, password);
				user.setAboutMe(aboutMe);
				user.setInterests(interests);
			}
		}
		return user;
	}
	
	public static ArrayList<Organization> getOrganizations() {
		return organizations;
	}
	
	public static ArrayList<Volunteer> getVolunteers() {
		return volunteers;
	}
	
	public static ArrayList<Event> getEvents() {
		return events;
	}


}
