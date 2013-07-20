package com.microdg.gwt.monitor.client.control;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class GetKeywordsCallback implements AsyncCallback<KeywordDTO[]> {

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(KeywordDTO[] result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("keywords-table",result));
	}

}
