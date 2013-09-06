package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;

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
public class ClientEmployeeViewUi extends EventDrivenComposite {
	public static String CLIENTEMPLOYEEVIEWUI = "clientemployeeviewui";
	private static ClientEmployeeViewUiUiBinder uiBinder = GWT
			.create(ClientEmployeeViewUiUiBinder.class);

	interface ClientEmployeeViewUiUiBinder extends
			UiBinder<Widget, ClientEmployeeViewUi> {
	}

	public ClientEmployeeViewUi() {
		initWidget(uiBinder.createAndBindUi(this));
		this.setChannels(CLIENTEMPLOYEEVIEWUI);
		bind();
	}

	@UiField
	Button button;

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	@Override
	public void handleEvent(String command, Widget message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEvent(JavaScriptObject message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEvent(String command, Widget[] messages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleObjectEvent(Object message) {
		// TODO Auto-generated method stub
		
	}

}
