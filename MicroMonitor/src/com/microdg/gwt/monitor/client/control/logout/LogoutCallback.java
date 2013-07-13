package com.microdg.gwt.monitor.client.control.logout;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.events.StringEvent;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;

public class LogoutCallback implements AsyncCallback<Boolean> {
		@Override
		public void onFailure(Throwable caught) {
			EventBus.handleNativeEvent(new StringEvent("app-error","Error logging out"));
		}

		@Override
		public void onSuccess(Boolean result) {
			EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getLoginPage());
		}
	}