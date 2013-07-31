package com.microdg.gwt.monitor.client.history;

import com.microdg.gwt.monitor.client.view.SiteListUi;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposureSitesPageHandler implements ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / Sites"));
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, new SiteListUi());
	}

}
