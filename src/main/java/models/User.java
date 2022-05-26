package models;

public class User {

	private int id;
	private String username;
	private String pasword;
	
	User(int id,String username, String password){
		this.id=id;
		this.username=username;
		this.pasword=password;
	}
	
	User(String username, String password){
		this.username=username;
		this.pasword=password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	

	
}
