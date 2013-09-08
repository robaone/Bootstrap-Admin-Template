package com.microdg.gwt.monitor.client.history;

import com.google.gwt.regexp.shared.RegExp;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.callback.ClientCallback;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposureClientViewHandler implements ApplicationHistoryHandler {
	String[] parsedPath;
	@Override
	public void handle(String[] parsed) {
		this.parsedPath = parsed;
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / Client"));
		MicroMonitor.dataService.getClient(this.getClientId(), new ClientCallback(this.getClientId()));
	}

	private Integer getClientId() {
		String id = parsedPath[1];
		return new Integer(id);
	}

	public static boolean is(String page) {
		RegExp p = RegExp.compile("^massexposure[/]clients[/][0-9]+$");
		return p.test(page);
	}

}
