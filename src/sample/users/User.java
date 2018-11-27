package sample.users;

public class User {

	private final String TYPE;
	public static final String VOLUNTEER = "VOLUNTEER";
	public static final String ORGANIZATION = "ORGANIZATION";

	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String aboutMe;
	protected String[] interests = new String[3];
	protected String email;
	protected String address;
	protected String password;
	
	protected String tvName;


	public User(String type, String userName, String firstName, String lastName, String email, String address,
			String password) {
		TYPE = type;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public String getType() {
		return TYPE;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getTvName() {
		return tvName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public String getUserData() {
		String data = TYPE + ":" + userName + ":" + firstName + ":" + lastName + ":" + getAboutMe() //
				+ ":" + getInterests()[0] + ":" + getInterests()[1] + ":" + getInterests()[2] + ":" //
				+ email + ":" + address + ":" + password;
		return data;
	}

	public void setAboutMe(String text) {
		this.aboutMe = text;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setInterests(String[] interests) {
		this.interests = interests;
	}

	public String[] getInterests() {
		return interests;
	}

}
