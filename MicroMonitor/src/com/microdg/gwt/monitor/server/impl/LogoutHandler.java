package com.microdg.gwt.monitor.server.impl;

import com.microdg.gwt.monitor.server.LogoutHandlerTemplate;

public class LogoutHandler implements LogoutHandlerTemplate {

	@Override
	public boolean logout() {
		System.out.print("Logging out user");
		return true;
	}

}
