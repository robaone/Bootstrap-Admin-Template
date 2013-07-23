package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class GetServceAreasCallback implements AsyncCallback<ServiceAreaDTO[]> {

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(ServiceAreaDTO[] result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("servicearea-table",result));
	}

}
