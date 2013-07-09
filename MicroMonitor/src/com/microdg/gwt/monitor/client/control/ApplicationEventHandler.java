package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;

public interface ApplicationEventHandler {

	void handle(Object message);

	void handleJs(JavaScriptObject message);

}
