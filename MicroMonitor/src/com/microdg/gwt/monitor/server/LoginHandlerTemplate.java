package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

public interface LoginHandlerTemplate {

	boolean login(LoginInfoDTO message);

}
