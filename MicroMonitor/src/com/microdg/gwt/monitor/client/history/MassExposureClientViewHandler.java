package com.microdg.gwt.monitor.client.history;

import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.view.ClientViewUi;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposureClientViewHandler implements ApplicationHistoryHandler {
	String[] parsedPath;
	@Override
	public void handle(String[] parsed) {
		this.parsedPath = parsed;
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / Client"));
		MicroMonitor.dataService.getClient(this.getClientId(), new AsyncCallback<ClientDTO>(){

			@Override
			public void onFailure(Throwable caught) {
				EventBus.handleObjectEvent(new ObjectChannelEvent("app-error",caught.getMessage()));
			}

			@Override
			public void onSuccess(ClientDTO result) {
				EventBus.handleObjectEvent(new ObjectChannelEvent(ClientViewUi.CLIENTVIEWUI,result));
				EventBus.handleEvent("root-content", ComposeEvent.REPLACE, MicroMonitor.getClientView());
			}
			
		});
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
