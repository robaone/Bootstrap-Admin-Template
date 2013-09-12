package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.view.ClientViewUi;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.EmployeeDTO;
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
public class ApplicationSaveClientEmployeHandler implements
		ApplicationEventHandler<EmployeeDTO> {

	@Override
	public void handle(EmployeeDTO message) {
		MicroMonitor.dataService.saveClientEmployee(message,new AsyncCallback<EmployeeDTO>(){

			@Override
			public void onFailure(Throwable caught) {
				EventBus.handleObjectEvent(new ObjectChannelEvent("app-error",caught.getMessage()));
			}

			@Override
			public void onSuccess(EmployeeDTO result) {
				History.newItem("massexposure/clients/"+result.getClientId());
			}
			
		});
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
