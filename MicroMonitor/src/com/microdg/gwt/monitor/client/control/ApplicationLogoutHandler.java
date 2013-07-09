package com.microdg.gwt.monitor.client.control;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.NativeChannelEvent;

public class ApplicationLogoutHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		MicroMonitor.dataService.logout(new AsyncCallback<Boolean>(){

			@Override
			public void onFailure(Throwable caught) {
				EventBus.handleNativeEvent(new NativeChannelEvent("app-error","Error logging out"));
			}

			@Override
			public void onSuccess(Boolean result) {
				EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getLoginPage());
			}
			
		});
	}

}
