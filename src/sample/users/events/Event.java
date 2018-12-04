package sample.users.events;

import java.util.ArrayList;

import sample.users.database.DataBase;

public class Event {

	private String host;
	private String name;
	private String address;
	private String date;
  private String time;
	private String description;
  private final int GOAL;

	private String tvName;

  public Event(String host, String name, String date, String time, String address, int goal) {
		this.host = host;
		this.name = name;
		this.date = date;
    this.time = time;
		this.address = address;
    GOAL = goal;
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
    text += "\n" //
        + "Date: " + date + "\n" //
        + "Time: " + time + "\n" //
        + "Goal: " + getParticipants() + " / " + GOAL + "\n";
    this.description = text;

  }

	public String getDescription() {
		return description;
	}

  public String getEventData() {
    return host + ":" + name + ":" + date + ":" + time + ":" + address + ":" + description
        .split("\n")[0] + ":"
        + GOAL;
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
