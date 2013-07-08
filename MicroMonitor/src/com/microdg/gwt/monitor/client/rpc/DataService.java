package com.microdg.gwt.monitor.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {

	boolean login(LoginInfoDTO message);

	boolean logout();

}
