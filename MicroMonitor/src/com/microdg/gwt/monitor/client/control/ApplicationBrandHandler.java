package com.microdg.gwt.monitor.client.control;

import com.microdg.gwt.monitor.client.MicroMonitor;

public class ApplicationBrandHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		MicroMonitor.getMainLayoutUi().setBrand(message.toString());
	}

}
