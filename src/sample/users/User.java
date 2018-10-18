package sample.users;

public class User {

	private final String TYPE;
	public static final String VOLUNTEER = "VOLUNTEER";
	public static final String ORGANIZATION = "ORGANIZATION";

	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String address;
	protected String password;

	public User(String type, String userName, String firstName, String lastName, String email, String address, String password) {
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

	public String getAllData() {
		String data = TYPE + ":" + userName + ":" + password + ":" + firstName + ":" + lastName + ":" + email + ":" + address;
		return data;
	}

}
