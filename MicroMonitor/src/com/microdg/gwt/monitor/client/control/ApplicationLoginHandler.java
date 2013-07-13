package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.control.login.LoginCallback;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

public class ApplicationLoginHandler implements ApplicationEventHandler<LoginInfoDTO> {
	
	@Override
	public void handle(LoginInfoDTO message) {
		MicroMonitor.dataService.login(message, new LoginCallback());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub
		
	}

}
