package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.FieldErrorDTO;
import com.microdg.gwt.monitor.shared.dto.GeneralErrorDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class LoginCallback implements AsyncCallback<Boolean> {
	@Override
	public void onFailure(Throwable caught) {
		if(caught instanceof SimpleException){
			GeneralErrorDTO error = new GeneralErrorDTO(caught.getMessage());
			EventBus.handleObjectEvent(new ObjectChannelEvent("loginui",error));
		}else if(caught instanceof FieldException){
			FieldException fe = (FieldException)caught;
			for(int i = 0; i < fe.getFieldErrorCount();i++){
				FieldErrorDTO error = new FieldErrorDTO(fe.getFields()[i],fe.getFieldError(fe.getFields()[i]));
				EventBus.handleObjectEvent(new ObjectChannelEvent("loginui",error));
			}
		}
		EventBus.handleObjectEvent(new ObjectChannelEvent("login-error","Login Failed"));
	}

	@Override
	public void onSuccess(Boolean result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("login-result",result));
	}
}