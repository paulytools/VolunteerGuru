package sample.users;

import java.util.ArrayList;

import sample.users.database.Database;
import sample.users.events.Action;

public class Organization extends User {

	public Organization(String type, String userName, String firstName, String lastName, String email, String address,
			String password) {
		super(type, userName, firstName, lastName, email, address, password);
		tvName = userName + "\n" + getFollowers() + " Followers";
	}

	// Allows organization to invite a volunteer
	public void inviteVolunteer(Volunteer volunteer) {
		ArrayList<String> actions = Database.getActionList();
		if (!actions.toString().contains(Action.INVITE.toString())) 
			Database.saveAction(Action.INVITE, volunteer, this);
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("INVITE")) {
				String vol = actions.get(i).split(":")[1]; // volunteer
				String org = actions.get(i).split(":")[2]; // organization
				// Checks if user is already invited
				if (!(vol.equals(volunteer.userName) && org.equals(userName))) {
					Database.saveAction(Action.INVITE, volunteer, this);
				}
			}
		}
	}

	// Finds all volunteers attending an event
	public int getFollowers() {
		ArrayList<String> actions = Database.getActionList();
		int followers = 0;
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("FOLLOW")) {
				if (actions.get(i).split(":")[2].equals(userName)) {
					followers++;
				}
			}
		}
		return followers;
	}
}
