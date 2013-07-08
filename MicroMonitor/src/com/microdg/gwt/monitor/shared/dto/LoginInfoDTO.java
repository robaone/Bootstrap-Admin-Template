package com.microdg.gwt.monitor.shared.dto;

public class LoginInfoDTO {

	private String m_username;
	private String m_password;

	public void setUsername(String username_string) {
		this.m_username = username_string;
	}

	public void setPassword(String password_string) {
		this.m_password = password_string;
	}

	public String getUsername(){
		return this.m_username;
	}
	
	public String getPassword(){
		return this.m_password;
	}
}
