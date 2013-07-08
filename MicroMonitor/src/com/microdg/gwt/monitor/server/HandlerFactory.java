package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.server.impl.LoginHandler;
import com.microdg.gwt.monitor.server.impl.LogoutHandler;

public class HandlerFactory {

	public static LoginHandlerTemplate newLoginHandler() {
		return new LoginHandler();
	}

	public static LogoutHandlerTemplate newLogoutHandler() {
		return new LogoutHandler();
	}

}
