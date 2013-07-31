package com.microdg.gwt.monitor.client.history;

import com.google.gwt.regexp.shared.RegExp;
import com.microdg.gwt.monitor.client.view.ClientViewUi;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposureClientViewHandler implements ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / Client"));
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, new ClientViewUi());
	}

	public static boolean is(String page) {
		RegExp p = RegExp.compile("massexposure[/]clients[/][0-9]+");
		return p.test(page);
	}

}
