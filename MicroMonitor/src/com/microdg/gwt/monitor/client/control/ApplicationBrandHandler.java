package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;

public class ApplicationBrandHandler implements ApplicationEventHandler<Object> {

	@Override
	public void handle(Object message) {
		MicroMonitor.getMainLayoutUi().setBrand(message.toString());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		String text = this.getText(message);
		this.handle(text);
	}
	
	public native String getText(JavaScriptObject message)/*-{
		return message.text;
	}-*/;

}
