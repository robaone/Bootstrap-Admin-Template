package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;

public interface ApplicationEventHandler<M> {

	void handle(M message);

	void handleJs(JavaScriptObject message);

}
