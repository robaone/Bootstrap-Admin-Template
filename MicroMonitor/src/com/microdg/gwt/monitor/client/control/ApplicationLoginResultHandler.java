package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;

public class ApplicationLoginResultHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		try{
			Boolean result = (Boolean)message;
			if(result.booleanValue()){
				MicroMonitor.dataService.getSessionData(new AsyncCallback<AppSessionDataDTO>(){

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess(AppSessionDataDTO result) {
						MicroMonitor.setAppSessionData(result);
						if(result.getProfile() != null){
							EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayoutUi());
						}else{
							EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getLoginPage());
						}
					}
					
				});
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub
		
	}

}
