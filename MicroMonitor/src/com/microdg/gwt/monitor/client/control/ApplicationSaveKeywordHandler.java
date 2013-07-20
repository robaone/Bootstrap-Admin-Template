package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.callback.SaveKeywordCallback;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;

public class ApplicationSaveKeywordHandler implements ApplicationEventHandler<KeywordDTO> {

	@Override
	public void handle(KeywordDTO message) {
		MicroMonitor.dataService.saveSiteKeyword(message,new SaveKeywordCallback());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
