package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.control.logout.LogoutCallback;
import com.microdg.gwt.monitor.client.events.StringEvent;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.NativeChannelEvent;

public class ApplicationLogoutHandler implements ApplicationEventHandler<Object> {

	

	@Override
	public void handle(Object message) {
		MicroMonitor.dataService.logout(new LogoutCallback());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub
		
	}

}
