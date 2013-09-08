package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.view.ClientViewUi;
import com.microdg.gwt.monitor.shared.dto.EmployeeDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public final class ClientEmployeesCallback implements
AsyncCallback<EmployeeDTO[]> {
	@Override
	public void onFailure(Throwable caught) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("app-error",caught.getMessage()));
	}

	@Override
	public void onSuccess(EmployeeDTO[] result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent(ClientViewUi.CLIENTVIEWUI, result));
	}
}