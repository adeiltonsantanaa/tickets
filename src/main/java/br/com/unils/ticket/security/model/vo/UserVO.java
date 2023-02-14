package br.com.unils.ticket.security.model.vo;

import java.io.Serializable;

public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String fullName;
	private String password;
	private String email;

	public UserVO() {
	}

	public UserVO(String username, String fullName, String password, String email) {
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
