package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.NativeChannelEvent;

public class ApplicationLoginHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		MicroMonitor.dataService.login((LoginInfoDTO)message, new AsyncCallback<Boolean>(){

			@Override
			public void onFailure(Throwable caught) {
				EventBus.handleNativeEvent(new NativeChannelEvent("login-error","Login Failed"));
			}

			@Override
			public void onSuccess(Boolean result) {
				EventBus.handleNativeEvent(new NativeChannelEvent("login-result",result));
			}
			
		});
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub
		
	}

}
