package com.microdg.gwt.monitor.server.impl;

import com.microdg.gwt.monitor.server.LoginHandlerTemplate;
import com.microdg.gwt.monitor.server.SessionData;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.FieldVerifier;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

public class LoginHandler implements LoginHandlerTemplate {

	public LoginHandler(SessionData sessionData) {
		
	}

	@Override
	public boolean login(LoginInfoDTO message)  throws SimpleException, FieldException{
		System.out.println("Logging in "+message.getUsername());
		FieldException fe = new FieldException();
		if(!FieldVerifier.exists(message.getUsername())){
			fe.addError("username", "Username is missing");
		}
		if(!FieldVerifier.exists(message.getPassword())){
			fe.addError("password", "Password is missing");
		}
		if(fe.hasErrors()){
			throw fe;
		}
		if("error".equalsIgnoreCase(message.getUsername())){
			throw new SimpleException("General Error");
		}
		return true;
	}

}
