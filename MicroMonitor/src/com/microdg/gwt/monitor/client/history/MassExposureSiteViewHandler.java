package com.microdg.gwt.monitor.client.history;

import com.google.gwt.regexp.shared.RegExp;
import com.microdg.gwt.monitor.client.view.SiteViewUi;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposureSiteViewHandler implements ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure / Site"));
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE,new SiteViewUi());
	}

	public static boolean is(String page) {
		RegExp p = RegExp.compile("massexposure[/]sites[/][0-9]+");
		return p.test(page);
	}

}
