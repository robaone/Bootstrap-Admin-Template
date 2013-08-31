package com.microdg.gwt.monitor.client.jo;

import com.google.gwt.core.client.JavaScriptObject;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;

public class ClientJO extends JavaScriptObject {
		protected ClientJO(){}
		public final native String getName()/*-{
			return this.name;
		}-*/;
		public final native int getClientId()/*-{
			return this.clientid;
		}-*/;
		public final ClientDTO toClientDTO(){
			ClientDTO client = new ClientDTO();
			client.setClientId(this.getClientId());
			client.setName(this.getName());
			return client;
		}
	}