package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.callback.LogoutCallback;

public class ApplicationLogoutHandler implements ApplicationEventHandler<Object> {

	

	@Override
	public void handle(Object message) {
		MicroMonitor.dataService.logout(new LogoutCallback());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		MicroMonitor.dataService.logout(new LogoutCallback());
	}

}
