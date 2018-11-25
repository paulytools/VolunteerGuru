package sample.users;

public class Organization extends User {

	public Organization(String type, String userName, String firstName, String lastName, String email, String address, String password) {
		super(type, userName, firstName, lastName, email, address, password);
	}

	@Override
	public String toString() {
		return
				"Username:	" +getUserName()+"\n"+
				"Address:	" +getAddress()+"\n"+
				"Email:		" +getEmail()+"\n"+
				"Type:		" +getType()+"\n";
	}
}
