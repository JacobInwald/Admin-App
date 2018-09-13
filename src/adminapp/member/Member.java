package adminapp.member;

public class Member {

	private String firstName, DofB, secondName;
	private int age;
	
	public Member(String name, String secondName, int age, String DofB) {
		this.firstName = name;
		this.secondName = secondName;
		this.age = age;
		this.DofB = DofB;
	
	}

	public String getFirstName() {
		return firstName;
	}

	public String getDofB() {
		return DofB;
	}

	public int getAge() {
		return age;
	}



	public String getSecondName() {
		return secondName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setDofB(String dofB) {
		DofB = dofB;
	}

	public void setAge(int age) {
		this.age = age;
	}



	
	
}
