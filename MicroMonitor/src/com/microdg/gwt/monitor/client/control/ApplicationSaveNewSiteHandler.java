package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.callback.CreateNewSiteCallback;

public class ApplicationSaveNewSiteHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		String sitename = message.toString();
		MicroMonitor.dataService.createNewSite(sitename,new CreateNewSiteCallback());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
