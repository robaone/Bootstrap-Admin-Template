package com.microdg.gwt.monitor.client.callback;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;

public class SaveKeywordCallback implements AsyncCallback<KeywordDTO> {

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(KeywordDTO result) {
		History.newItem("sites/view/"+result.getSiteId());
	}

}
