package com.microdg.gwt.monitor.client.control.login;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.events.BooleanEvent;
import com.microdg.gwt.monitor.client.events.StringEvent;
import com.robaone.gwt.eventbus.client.EventBus;

public class LoginCallback implements AsyncCallback<Boolean> {
	@Override
	public void onFailure(Throwable caught) {
		EventBus.handleNativeEvent(new StringEvent("login-error","Login Failed"));
	}

	@Override
	public void onSuccess(Boolean result) {
		EventBus.handleNativeEvent(new BooleanEvent("login-result",result));
	}
}