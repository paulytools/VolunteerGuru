package sample.users;

import java.util.ArrayList;

import sample.users.database.DataBase;
import sample.users.events.Action;
import sample.users.events.Event;

public class Volunteer extends User {

	public Volunteer(String type, String userName, String firstName, String lastName, String email, String address,
			String password) {
		super(type, userName, firstName, lastName, email, address, password);
		tvName = userName + "\n" + getInvites() + " Invites";
	}


	// Allows volunteer to join an event
	public void attendEvent(Event event) {
		ArrayList<String> actions = DataBase.getActionList();
		if (!actions.toString().contains(Action.EVENT.toString()))
			DataBase.saveAction(Action.EVENT, this, event);
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("EVENT")) {
				String user = actions.get(i).split(":")[1];
				String e = actions.get(i).split(":")[2];
				// Checks if volunteer has already joined event
				if (!(user.equals(userName) && e.equals(event.getName()))) {
					DataBase.saveAction(Action.EVENT, this, event);

				}
			}
		}
	}

	// Allows volunteer to follow an organization
	public void followOrganization(Organization organization) {
		ArrayList<String> actions = DataBase.getActionList();
		if (!actions.toString().contains(Action.FOLLOW.toString()))
			DataBase.saveAction(Action.FOLLOW, this, organization);
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("FOLLOW")) {
				String vol = actions.get(i).split(":")[1]; // volunteer
				String org = actions.get(i).split(":")[2]; // organization
				// Checks if user is already following
				if (!(vol.equals(userName) && org.equals(organization.getUserName()))) {
					DataBase.saveAction(Action.FOLLOW, this, organization);

				}
			}
		}
	}

	// Finds all invites received
	public int getInvites() {
		ArrayList<String> actions = DataBase.getActionList();
		int invites = 0;
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("INVITE")) {
				if (actions.get(i).split(":")[1].equals(userName)) {
					invites++;
				}
			}
		}
		return invites;
	}

}
