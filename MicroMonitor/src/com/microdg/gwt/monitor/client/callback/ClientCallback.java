package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.view.ClientViewUi;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public final class ClientCallback implements AsyncCallback<ClientDTO> {
	private int clientId;
	public ClientCallback(int clientid){
		this.setClientId(clientid);
	}
	@Override
	public void onFailure(Throwable caught) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("app-error",caught.getMessage()));
	}

	@Override
	public void onSuccess(ClientDTO result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent(ClientViewUi.CLIENTVIEWUI,result));
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, MicroMonitor.getClientView());
		MicroMonitor.dataService.getClientEmployees(getClientId(), new ClientEmployeesCallback());
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
}