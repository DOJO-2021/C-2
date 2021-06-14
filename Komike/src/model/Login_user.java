package model;

import java.io.Serializable;

public class Login_user implements Serializable {
	private String id;	// ログイン時のID

	public Login_user() {
		this(null);
	}

	public Login_user(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setUserId(String id) {
		this.id = id;
	}
}
