package com.microdg.gwt.monitor.server.impl;

import com.microdg.gwt.monitor.server.LoginHandlerTemplate;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

public class LoginHandler implements LoginHandlerTemplate {

	@Override
	public boolean login(LoginInfoDTO message) {
		System.out.println("Logging in "+message.getUsername());
		return true;
	}

}
