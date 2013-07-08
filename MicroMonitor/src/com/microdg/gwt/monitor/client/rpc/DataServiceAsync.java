package com.microdg.gwt.monitor.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

public interface DataServiceAsync {

	void login(LoginInfoDTO message,AsyncCallback<Boolean> response);

	void logout(AsyncCallback<Boolean> asyncCallback);

}
