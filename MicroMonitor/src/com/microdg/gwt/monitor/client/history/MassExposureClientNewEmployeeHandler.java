package com.microdg.gwt.monitor.client.history;

import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.view.ClientEmployeeEditFormUi;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

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
public class MassExposureClientNewEmployeeHandler implements
		ApplicationHistoryHandler {
	String[] parameters;
	@Override
	public void handle(String[] parsed) {
		this.setParameters(parsed);
		MicroMonitor.dataService.getClient(getClientId(), new AsyncCallback<ClientDTO>(){

			@Override
			public void onFailure(Throwable caught) {
				EventBus.handleObjectEvent(new ObjectChannelEvent("app-error",caught.getMessage()));
			}

			@Override
			public void onSuccess(ClientDTO result) {
				EventBus.handleObjectEvent(new ObjectChannelEvent(ClientEmployeeEditFormUi.CLIENTEMPLOYEEEDITFORMUI,result));
				EventBus.handleEvent("root-content", ComposeEvent.REPLACE, MicroMonitor.getClientEmployeeEditForm());
			}
			
		});
	}
	protected void setParameters(String[] params){
		this.parameters = params;
	}
	private Integer getClientId() {
		return new Integer(this.parameters[1]);
	}

	public static boolean is(String page) {
		RegExp p = RegExp.compile("^massexposure[/]clients[/][0-9]+/employee[/]new$");
		return p.test(page);
	}

}
