package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event.Type;
import com.robaone.gwt.eventbus.client.EventBusConstants;
import com.robaone.gwt.eventbus.client.EventDrivenController;
import com.robaone.gwt.eventbus.client.NativeMessageHandler;

public class AppController extends EventDrivenController<GwtEvent.Type<NativeMessageHandler<String>>,Object> {
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
		ApplicationComposeEventHandler handler = ApplicationComposeEventFactory.newInstance(this.getChannel());
		if(handler != null){
			try{
				handler.handle(command,message);
			}catch(Exception e){
				
			}
		}
	}

	@Override
	public void handleEvent(String command, Widget[] messages) {
		System.out.println("AppController: "+command);
		ApplicationComposeEventHandler handler = ApplicationComposeEventFactory.newInstance(this.getChannel());
		if(handler != null){
			try{
				handler.handle(command,messages);
			}catch(Exception e){
				
			}
		}
	}

	@Override
	public void handleEvent(JavaScriptObject message) {
		System.out.println("AppController: "+message.toString());
		ApplicationEventHandler handler = ApplicationEventFactory.newInstance(this.getChannel());
		if(handler != null){
			try{
				handler.handleJs(message);
			}catch(Exception e){}
		}
	}

	@Override
	public void handleNativeEvent(Object message) {
		System.out.println("AppController: "+message.getClass().getName());
		ApplicationEventHandler handler = ApplicationEventFactory.newInstance(this.getChannel());
		if(handler != null){
			try{
				handler.handle(message);
			}catch(Exception e){}
		}
	}
	private String getChannel() {
		return this.m_channel;
	}
	@Override
	protected Type<NativeMessageHandler<Object>> getNativeEventType() {
		return EventBusConstants.OBJECT_TYPE;
	}

}
