package com.microdg.gwt.monitor.client.control.login;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class LoginCallback implements AsyncCallback<Boolean> {
	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
		EventBus.handleObjectEvent(new ObjectChannelEvent("login-error","Login Failed"));
	}

	@Override
	public void onSuccess(Boolean result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("login-result",result));
	}
}