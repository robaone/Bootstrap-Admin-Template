package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

public interface LoginHandlerTemplate {

	boolean login(LoginInfoDTO message) throws SimpleException, FieldException;

}
