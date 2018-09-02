package adminapp.member;

public class Member {

	private String name, DofB;
	private int age, id;
	
	public Member(String name, int age, String DofB, int id) {
		this.name = name;
		this.age = age;
		this.DofB = DofB;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDofB() {
		return DofB;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDofB(String dofB) {
		DofB = dofB;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
