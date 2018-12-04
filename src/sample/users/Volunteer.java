package sample.users;

import java.util.ArrayList;

import sample.users.database.DataBase;
import sample.users.events.Action;
import sample.users.events.Event;

public class Volunteer extends User {

	public Volunteer(String type, String userName, String firstName, String lastName, String email, String address,
			String password) {
		super(type, userName, firstName, lastName, email, address, password);
		tvName = getTvName();
	}

	// Allows volunteer to join an event
	public void attendEvent(Event event) {
		ArrayList<String> actions = DataBase.getActionList();
		if (!actions.toString().contains(Action.EVENT.toString())) {
			DataBase.saveAction(Action.EVENT, this, event);
			return;
		}
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("EVENT")) {
				String user = actions.get(i).split(":")[1];
				String e = actions.get(i).split(":")[2];
				// Checks if volunteer has already joined event
        if ((user.equals(userName) && e.equals(event.getName())))
					break;
      }
      if (i == actions.size() - 1)
				DataBase.saveAction(Action.EVENT, this, event);
		}
	}

	// Allows volunteer to follow an organization
	public void followOrganization(Organization organization) {
		ArrayList<String> actions = DataBase.getActionList();
		if (!actions.toString().contains(Action.FOLLOW.toString())) {
			DataBase.saveAction(Action.FOLLOW, this, organization);
			return;
		}
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("FOLLOW")) {
				String vol = actions.get(i).split(":")[1]; // volunteer
				String org = actions.get(i).split(":")[2]; // organization
				// Checks if a user is already in the database
        if ((vol.equals(userName) && org.equals(organization.getUserName())))
					break;
      }
      if (i == actions.size() - 1)
				DataBase.saveAction(Action.FOLLOW, this, organization);
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

	public ArrayList<String> getHostName() {
		ArrayList<String> actions = DataBase.getActionList();
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("INVITE")) {
				if (actions.get(i).split(":")[1].equals(userName)) {
					names.add(actions.get(i).split(":")[2]);
				}
			}
		}
		return names;
	}

	public String getTvName() {
		return userName + "\n" + getInvites() + " invites";
	}

}
