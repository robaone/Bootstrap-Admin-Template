package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;

public class ApplicationLoginResultHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		try{
			Boolean result = (Boolean)message;
			if(result.booleanValue()){
				EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayout());
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
