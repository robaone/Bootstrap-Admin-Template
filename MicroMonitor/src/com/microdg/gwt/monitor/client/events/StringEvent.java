package com.microdg.gwt.monitor.client.events;

import com.robaone.gwt.eventbus.client.NativeChannelEvent;
import com.robaone.gwt.eventbus.client.NativeMessageHandler;

public class StringEvent extends NativeChannelEvent<String>{

		public StringEvent(java.lang.String channel, String message) {
			super(channel, message);
		}

		@Override
		public com.google.web.bindery.event.shared.Event.Type<NativeMessageHandler<String>> getAssociatedType() {
			return new com.google.web.bindery.event.shared.Event.Type<NativeMessageHandler<String>>();
		}
		
	}