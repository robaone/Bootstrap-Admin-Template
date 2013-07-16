package com.microdg.gwt.monitor.client.history;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event.Type;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.view.main.MainLayoutUi;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.EventBusConstants;
import com.robaone.gwt.eventbus.client.EventDrivenController;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;
import com.robaone.gwt.eventbus.client.ObjectMessageHandler;

public class ApplicationHistory extends EventDrivenController implements
		ValueChangeHandler<String> {
	public ApplicationHistory(){
		bind();
	}
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		this.handleObjectEvent(event.getValue());
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
	public void handleObjectEvent(Object message) {
		System.out.println("ApplicationHistory: "+message);
		if("".equals(message.toString()) || "home".equalsIgnoreCase(message.toString())){
			EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayoutUi());
			EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Home"));
		}else if("settings".equals(message.toString())){
			EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayoutUi());
			EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Settings"));
		}else if("dashboard".equals(message.toString())){
			setPage(MicroMonitor.getMainLayoutUi(),"Dashboard");
		}
	}
	private void setPage(MainLayoutUi mainLayoutUi, String string) {
		EventBus.handleEvent("root", ComposeEvent.REPLACE, mainLayoutUi);
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name",string));
	}

}
