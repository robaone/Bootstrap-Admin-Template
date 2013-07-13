package com.microdg.gwt.monitor.client.history;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event.Type;
import com.robaone.gwt.eventbus.client.EventBusConstants;
import com.robaone.gwt.eventbus.client.EventDrivenController;
import com.robaone.gwt.eventbus.client.NativeMessageHandler;

public class ApplicationHistory extends EventDrivenController<GwtEvent.Type<NativeMessageHandler<String>>,String> implements
		ValueChangeHandler<String> {

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEvent(String command, Widget message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEvent(String command, Widget[] messages) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEvent(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleNativeEvent(String message) {
		System.out.println("ApplicationHistory: "+message);
	}

	@Override
	protected Type<NativeMessageHandler<String>> getNativeEventType() {
		return EventBusConstants.STRING_TYPE;
	}

}
