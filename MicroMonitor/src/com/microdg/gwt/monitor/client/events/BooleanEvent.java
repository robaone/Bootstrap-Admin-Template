package com.microdg.gwt.monitor.client.events;

import com.robaone.gwt.eventbus.client.NativeChannelEvent;
import com.robaone.gwt.eventbus.client.NativeMessageHandler;

public class BooleanEvent extends NativeChannelEvent<Boolean>{

		public BooleanEvent(java.lang.String channel, Boolean message) {
			super(channel, message);
		}

		@Override
		public com.google.web.bindery.event.shared.Event.Type<NativeMessageHandler<Boolean>> getAssociatedType() {
			return new com.google.web.bindery.event.shared.Event.Type<NativeMessageHandler<Boolean>>();
		}
		
	}