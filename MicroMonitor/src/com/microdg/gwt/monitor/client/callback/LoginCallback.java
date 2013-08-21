package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.view.login.LoginUi;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.GeneralErrorDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class LoginCallback implements AsyncCallback<Boolean> {
	@Override
	public void onFailure(Throwable caught) {
		if(caught instanceof SimpleException){
			GeneralErrorDTO error = new GeneralErrorDTO(caught.getMessage());
			EventBus.handleObjectEvent(new ObjectChannelEvent(LoginUi.LOGINUI,error));
		}else if(caught instanceof FieldException){
			FieldErrors.populate(caught, LoginUi.LOGINUI);
		}
		EventBus.handleObjectEvent(new ObjectChannelEvent(LoginUi.LOGINUI,new GeneralErrorDTO("Login Failed")));
	}

	@Override
	public void onSuccess(Boolean result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("login-result",result));
	}
}