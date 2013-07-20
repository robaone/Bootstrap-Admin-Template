package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class CreateNewSiteCallback implements AsyncCallback<SiteDTO> {

	@Override
	public void onFailure(Throwable caught) {
		caught.printStackTrace();
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(SiteDTO result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("site:view",result));
	}

}
