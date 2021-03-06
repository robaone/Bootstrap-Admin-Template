package com.microdg.gwt.monitor.server.impl;

import com.microdg.gwt.monitor.server.RecoverPasswordHandlerTemplate;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;

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
public class RecoverPasswordHandler implements RecoverPasswordHandlerTemplate {

	@Override
	public boolean recoverPassword(String email) throws SimpleException,
			FieldException {
		if("error".equalsIgnoreCase(email)){
			throw new SimpleException("General error");
		}else if(!"test@domain.com".equalsIgnoreCase(email)){
			FieldException exception = new FieldException();
			exception.addError("email", "Invalid Email");
			throw exception;
		}else{
			return true;
		}
	}

}
