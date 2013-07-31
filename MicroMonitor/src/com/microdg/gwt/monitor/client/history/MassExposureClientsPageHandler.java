package com.microdg.gwt.monitor.client.history;

import com.microdg.gwt.monitor.client.view.ClientsUi;
import com.microdg.gwt.monitor.shared.ArrayTools;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposureClientsPageHandler implements
		ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / Clients"));
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, new ClientsUi());
		
	}

}
