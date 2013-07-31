package com.microdg.gwt.monitor.client.history;

import com.google.gwt.user.client.Window;
import com.microdg.gwt.monitor.shared.ArrayTools;

public class ErrorPageHandler implements ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		String str = ArrayTools.toString(parsed);
		showError(str);
	}

	public void handle(Exception e) {
		showError(e.getClass().getName()+": "+e.getMessage());
	}
	
	private void showError(String str){
		Window.alert(str);
	}

}
