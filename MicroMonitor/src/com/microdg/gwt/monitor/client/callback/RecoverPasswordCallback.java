package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.view.login.LoginUi;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.FieldErrorDTO;
import com.microdg.gwt.monitor.shared.dto.GeneralErrorDTO;
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
public class RecoverPasswordCallback implements AsyncCallback<Boolean> {

	@Override
	public void onFailure(Throwable caught) {
		if(caught instanceof SimpleException){
			GeneralErrorDTO error = new GeneralErrorDTO(caught.getMessage());
			EventBus.handleObjectEvent(new ObjectChannelEvent(LoginUi.PASSWORDRESETUI,error));
		}else if(caught instanceof FieldException){
			String ui = LoginUi.PASSWORDRESETUI;
			FieldErrors.populate(caught, ui);
		}
	}

	

	@Override
	public void onSuccess(Boolean result) {
		if(result){
			EventBus.handleObjectEvent(new ObjectChannelEvent("recover-password-success",result));
		}else{
			EventBus.handleObjectEvent(new ObjectChannelEvent(LoginUi.PASSWORDRESETUI,new GeneralErrorDTO("Reset failed")));
		}
	}

}
