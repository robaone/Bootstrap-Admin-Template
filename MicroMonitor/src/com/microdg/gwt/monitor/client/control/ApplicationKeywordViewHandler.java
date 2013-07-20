package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public class ApplicationKeywordViewHandler implements ApplicationEventHandler<SiteDTO> {

	@Override
	public void handle(SiteDTO message) {
		MicroMonitor.dataService.getSiteKeywords(message.getId(),new GetKeywordsCallback());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
