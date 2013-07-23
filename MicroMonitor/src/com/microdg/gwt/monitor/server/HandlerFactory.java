package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.server.impl.AppSessionHandler;
import com.microdg.gwt.monitor.server.impl.KeywordHandler;
import com.microdg.gwt.monitor.server.impl.LoginHandler;
import com.microdg.gwt.monitor.server.impl.LogoutHandler;
import com.microdg.gwt.monitor.server.impl.ServiceAreaHandler;
import com.microdg.gwt.monitor.server.impl.SitesHandler;

public class HandlerFactory {

	public static LoginHandlerTemplate newLoginHandler() {
		return new LoginHandler();
	}

	public static LogoutHandlerTemplate newLogoutHandler() {
		return new LogoutHandler();
	}

	public static AppSessionHandlerTemplace newAppSessionHandler() {
		return new AppSessionHandler();
	}

	public static SitesHandlerTemplate newSitesHandler() {
		return new SitesHandler();
	}

	public static KeywordHandlerTemplate newKeywordHandler() {
		return new KeywordHandler();
	}

	public static ServiceAreaHandlerTemplate newServiceAreaHandler() {
		return new ServiceAreaHandler();
	}

}
