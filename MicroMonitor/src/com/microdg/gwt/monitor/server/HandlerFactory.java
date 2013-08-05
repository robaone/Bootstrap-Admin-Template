package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.server.impl.AppSessionHandler;
import com.microdg.gwt.monitor.server.impl.KeywordHandler;
import com.microdg.gwt.monitor.server.impl.LoginHandler;
import com.microdg.gwt.monitor.server.impl.LogoutHandler;
import com.microdg.gwt.monitor.server.impl.ServiceAreaHandler;
import com.microdg.gwt.monitor.server.impl.SitesHandler;

public class HandlerFactory {

	public static LoginHandlerTemplate newLoginHandler(SessionData sessionData) {
		return new LoginHandler(sessionData);
	}

	public static LogoutHandlerTemplate newLogoutHandler(SessionData sessionData) {
		return new LogoutHandler(sessionData);
	}

	public static AppSessionHandlerTemplace newAppSessionHandler(SessionData sessionData) {
		return new AppSessionHandler(sessionData);
	}

	public static SitesHandlerTemplate newSitesHandler(SessionData sessionData) {
		return new SitesHandler(sessionData);
	}

	public static KeywordHandlerTemplate newKeywordHandler(SessionData sessionData) {
		return new KeywordHandler(sessionData);
	}

	public static ServiceAreaHandlerTemplate newServiceAreaHandler(SessionData sessionData) {
		return new ServiceAreaHandler(sessionData);
	}

	public static AppSessionHandlerTemplace newAppSessionHandler() {
		return new AppSessionHandler();
	}

}
