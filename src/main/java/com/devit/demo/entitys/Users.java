package com.devit.demo.entitys;

public class Users {

	private Long id;
	private String userName;
	private String password;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [\n\tid=");
		builder.append(id);
		builder.append(", \n\tuserName=");
		builder.append(userName);
		builder.append(", \n\tpassword=");
		builder.append(password);
		builder.append(", \n\temail=");
		builder.append(email);
		builder.append("\n]");
		return builder.toString();
	}

}
