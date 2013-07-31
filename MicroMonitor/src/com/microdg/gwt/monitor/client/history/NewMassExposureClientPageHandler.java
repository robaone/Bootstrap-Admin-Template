package com.microdg.gwt.monitor.client.history;

import com.google.gwt.user.client.Window;
import com.microdg.gwt.monitor.client.view.ClientCreationFormUi;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class NewMassExposureClientPageHandler implements
		ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / New Client"));
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, new ClientCreationFormUi());
	}

}
