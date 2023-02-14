package br.com.unils.ticket.security.model.vo;

import java.io.Serializable;

public class UserVOResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String fullName;

	public UserVOResponse() {
	}

	public UserVOResponse(String username, String fullName) {
		this.username = username;
		this.fullName = fullName;
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

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
