package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.robaone.gwt.eventbus.client.EventDrivenController;

public class AppController extends EventDrivenController {
	private String m_channel;
	public AppController(){
		this.bind();
	}
	@Override
	public boolean inChannel(String channel){
		this.m_channel = channel;
		return true;
	}
	
	@Override
	public void handleEvent(String command, Widget message) {
		System.out.println("AppController: "+command);
	}

	@Override
	public void handleEvent(String command, Widget[] messages) {
		System.out.println("AppController: "+command);
	}

	@Override
	public void handleEvent(JavaScriptObject message) {
		System.out.println("AppController: "+message.toString());
		ApplicationEventHandler handler = ApplicationEventFactory.newInstance(this.getChannel());
		handler.handle(message);
	}

	@Override
	public void handleNativeEvent(Object message) {
		System.out.println("AppController: "+message.getClass().getName());
		ApplicationEventHandler handler = ApplicationEventFactory.newInstance(this.getChannel());
		if(handler != null){
			handler.handle(message);
		}
	}
	private String getChannel() {
		return this.m_channel;
	}

}
