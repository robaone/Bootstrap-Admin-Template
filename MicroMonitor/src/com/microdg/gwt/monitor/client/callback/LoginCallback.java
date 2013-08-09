package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class LoginCallback implements AsyncCallback<Boolean> {
	@Override
	public void onFailure(Throwable caught) {
		if(caught instanceof SimpleException){
			Window.alert("General Error: "+caught.getMessage());
		}else if(caught instanceof FieldException){
			Window.alert("Fields in Error: " + ((FieldException)caught).getFieldErrorCount());
		}
		EventBus.handleObjectEvent(new ObjectChannelEvent("login-error","Login Failed"));
	}

	@Override
	public void onSuccess(Boolean result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("login-result",result));
	}
}