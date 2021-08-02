package beans;

public class User {
	private int id;
	private int role_id;
	private String given_name;
	private String family_name;
	private String username;
	private String email;
	private String password;
	private String phone;

	public User(int id, int role_id, String given_name, String family_name, String username, String email,
			String password, String phone) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.given_name = given_name;
		this.family_name = family_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getGiven_name() {
		return given_name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", role_id=" + role_id + ", given_name=" + given_name + ", family_name=" + family_name
				+ ", username=" + username + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
