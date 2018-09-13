package adminapp.member;

public class User {

	private String firstName, lastName, password, username;
	
	public User(String userName, String lastName, String password) {
		this.firstName = userName;
		this.password = password;
		this.lastName = lastName;
		this.username = firstName.substring(0, 5) + lastName.substring(0, 1);
		System.out.println(username);
		}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	
}
