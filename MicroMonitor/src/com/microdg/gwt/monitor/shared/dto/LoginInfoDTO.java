package com.microdg.gwt.monitor.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LoginInfoDTO implements IsSerializable{

	private String m_username;
	private String m_password;
	private String m_email;

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

	public void setEmail(String email_string) {
		this.m_email = email_string;
	}
	
	public String getEmail() {
		return this.m_email;
	}
}
