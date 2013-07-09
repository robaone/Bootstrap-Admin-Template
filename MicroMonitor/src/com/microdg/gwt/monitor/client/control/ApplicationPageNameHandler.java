package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.client.MicroMonitor;

/**
 * <pre>   Copyright 2013 Ansel Robateau
         http://www.robaone.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.</pre>
 * @author Ansel
 *
 */
public class ApplicationPageNameHandler implements ApplicationEventHandler {

	@Override
	public void handle(Object message) {
		MicroMonitor.getMainLayoutUi().setPageName(message.toString());
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		String text = this.getText(message);
		handle(text);
	}

	private native String getText(JavaScriptObject message) /*-{
		return message.text;
	}-*/;

}
