package com.microdg.gwt.monitor.client.history;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.control.ApplicationEventFactory;
import com.microdg.gwt.monitor.client.rpc.ClientListUpdateHandler;
import com.microdg.gwt.monitor.client.view.ClientsUi;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposureClientsPageHandler implements
		ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / Clients"));
		MicroMonitor.dataService.getClients(new AsyncCallback<ClientDTO[]>(){

			@Override
			public void onFailure(Throwable caught) {
				EventBus.handleObjectEvent(new ObjectChannelEvent(ApplicationEventFactory.APP_ERROR, caught.getMessage()));
			}

			@Override
			public void onSuccess(ClientDTO[] result) {
				EventBus.handleObjectEvent(new ObjectChannelEvent(ClientsUi.CLIENTSUI, result));
				EventBus.handleEvent("root-content", ComposeEvent.REPLACE, MicroMonitor.getClientList());
			}
			
		});
		
	}

}
