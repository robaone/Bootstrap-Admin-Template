package com.microdg.gwt.monitor.client.events;

import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.robaone.gwt.eventbus.client.NativeChannelEvent;
import com.robaone.gwt.eventbus.client.NativeMessageHandler;

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
public class LoginInfoEvent extends NativeChannelEvent<LoginInfoDTO> {
	public static final com.google.web.bindery.event.shared.Event.Type<NativeMessageHandler<LoginInfoDTO>> TYPE = new Type<NativeMessageHandler<LoginInfoDTO>>();
	public LoginInfoEvent(String channel, LoginInfoDTO message) {
		super(channel, message);
	}

	@Override
	public com.google.web.bindery.event.shared.Event.Type<NativeMessageHandler<LoginInfoDTO>> getAssociatedType() {
		return TYPE;
	}

}
