package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.callback.GetServceAreasCallback;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public class ApplicationServiceAreaViewHandler implements
		ApplicationEventHandler<SiteDTO> {

	@Override
	public void handle(SiteDTO message) {
		MicroMonitor.dataService.getSiteServiceAreas(message.getId(),new GetServceAreasCallback());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
