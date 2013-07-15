package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
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
public class InitilizeCalback implements AsyncCallback<AppSessionDataDTO> {

	@Override
	public void onFailure(Throwable caught) {
		EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getLoginPage());
	}

	@Override
	public void onSuccess(AppSessionDataDTO result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-profile",result.getProfile()));
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-brand",result.getBrand()));
		EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayoutUi());
	}

}
