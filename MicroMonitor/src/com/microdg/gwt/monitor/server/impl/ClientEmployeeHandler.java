package com.microdg.gwt.monitor.server.impl;

import com.microdg.gwt.monitor.server.ClientEmployeeHandlerTemplate;
import com.microdg.gwt.monitor.server.SessionData;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.EmployeeDTO;

/**
 * <pre>   Copyright 2013 Ansel Robateau
         http://www.robaone.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.</pre>
 * @author Ansel
 *
 */
public class ClientEmployeeHandler implements ClientEmployeeHandlerTemplate {

	public ClientEmployeeHandler(SessionData sessionDataObject) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public EmployeeDTO[] getClientEmployees(Integer clientId)
			throws SimpleException {
		EmployeeDTO[] empl = new EmployeeDTO[1];
		empl[0] = new EmployeeDTO();
		empl[0].setName("First Employee");
		empl[0].setEmailAddress("email@domain.com");
		String[] roles = {"Owner","Operator"};
		empl[0].setRoles(roles);
		return empl;
	}

}
