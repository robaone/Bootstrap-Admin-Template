package com.microdg.gwt.monitor.server.impl;

import com.microdg.gwt.monitor.server.LogoutHandlerTemplate;
import com.microdg.gwt.monitor.server.SessionData;

public class LogoutHandler implements LogoutHandlerTemplate {

	public LogoutHandler(SessionData sessionData) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean logout() {
		System.out.print("Logging out user");
		return true;
	}

}
