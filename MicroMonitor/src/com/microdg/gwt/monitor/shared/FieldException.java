package com.microdg.gwt.monitor.shared;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.IsSerializable;

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
public class FieldException extends Exception implements IsSerializable{
	private static final long serialVersionUID = 1696016892105548311L;
	HashMap<String,String> fieldErrors = new HashMap<String,String>();
	public void addError(String fieldName, String errorMessage) {
		fieldErrors.put(fieldName, errorMessage);
	}

	public boolean hasErrors() {
		return fieldErrors.size() > 0;
	}

	@Override
	public void printStackTrace(){
		String[] keys = this.fieldErrors.keySet().toArray(new String[0]);
		for(String key : keys){
			System.err.print(key + " => ");
			System.err.println(this.fieldErrors.get(key));
		}
		super.printStackTrace();
	}
	public String getFieldError(String field){
		return fieldErrors.get(field);
	}
	public int getFieldErrorCount(){
		return fieldErrors.size();
	}
	public String[] getFields(){
		return fieldErrors.keySet().toArray(new String[0]);
	}
}
