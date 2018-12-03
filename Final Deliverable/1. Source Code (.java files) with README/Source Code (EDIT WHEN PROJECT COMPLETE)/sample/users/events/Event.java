package sample.users.events;

import java.util.ArrayList;

import sample.users.database.DataBase;

public class Event {
 
	private String host;
	private String name;
	private String address;
	private String date;
	private String description;
	
	private String tvName;
	
	public Event(String host, String name, String date, String address) {
		this.host = host;
		this.name = name;
		this.date = date;
		this.address = address;
		tvName = "[" + host + "]" + "\n" + name; 
	}
	
	public String getTvName() {
		return tvName;
	}
	
	public String getHost() {
		return host;
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setDescription(String text) {
		this.description = text + "\n" + date + "\n" + getParticipants() + " Participants";
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getEventData() {
		return host + ":" + name + ":" + date + ":" + address + ":" + description;
	}
	
	// Finds all volunteers attending an event
	public int getParticipants() {
		ArrayList<String> actions = DataBase.getActionList();
		int participants = 0;
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).split(":")[0].equals("EVENT")) {
				if (actions.get(i).split(":")[2].equals(name)) {
					participants++;
				}
			}
		}
		return participants;
	}
}
