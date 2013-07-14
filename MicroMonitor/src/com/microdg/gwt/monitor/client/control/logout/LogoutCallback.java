package com.microdg.gwt.monitor.client.control.logout;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class LogoutCallback implements AsyncCallback<Boolean> {
		@Override
		public void onFailure(Throwable caught) {
			EventBus.handleObjectEvent(new ObjectChannelEvent("app-error","Error logging out"));
		}

		@Override
		public void onSuccess(Boolean result) {
			EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getLoginPage());
		}
	}