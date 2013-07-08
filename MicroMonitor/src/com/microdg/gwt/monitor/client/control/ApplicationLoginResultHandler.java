package com.microdg.gwt.monitor.client.control;

import com.microdg.gwt.monitor.client.MicroMonitor;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;

public class ApplicationLoginResultHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		try{
			Boolean result = (Boolean)message;
			if(result.booleanValue()){
				EventBus.handleEvent("main-layout", ComposeEvent.REPLACE, MicroMonitor.getMainLayout());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
