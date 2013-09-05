package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.callback.FieldErrors;
import com.microdg.gwt.monitor.client.view.ClientCreationFormUi;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
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
public class ApplicationSaveClientHandler implements ApplicationEventHandler<ClientDTO> {

	@Override
	public void handle(ClientDTO message) {
		MicroMonitor.dataService.saveClient(message,new AsyncCallback<ClientDTO>(){

			@Override
			public void onFailure(Throwable caught) {
				if(caught instanceof SimpleException){
					EventBus.handleObjectEvent(new ObjectChannelEvent("app-error",caught.getMessage()));
				}else if(caught instanceof FieldException){
					FieldException fe = (FieldException)caught;
					FieldErrors.populate(caught, ClientCreationFormUi.CLIENTCREATIONFORMUI);
				}
			}

			@Override
			public void onSuccess(ClientDTO result) {
				History.newItem("massexposure/clients/"+result.getClientId());
			}
			
		});
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
