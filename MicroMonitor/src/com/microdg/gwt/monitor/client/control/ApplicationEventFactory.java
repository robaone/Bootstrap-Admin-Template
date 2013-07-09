package com.microdg.gwt.monitor.client.control;

public class ApplicationEventFactory {

	public static ApplicationEventHandler newInstance(String channel) {
		if("login".equals(channel)){
			return new ApplicationLoginHandler();
		}else if("login-result".equals(channel)){
			return new ApplicationLoginResultHandler();
		}else if("logout".equals(channel)){
			return new ApplicationLogoutHandler();
		}else if("set-brand".equals(channel)){
			return new ApplicationBrandHandler();
		}
		return null;
	}

}
