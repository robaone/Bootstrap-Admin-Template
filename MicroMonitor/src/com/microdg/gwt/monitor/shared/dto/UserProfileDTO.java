package com.microdg.gwt.monitor.shared.dto;

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
public class UserProfileDTO implements IsSerializable {
	private java.util.Date lastaccessed;
	private String username;
	private String accounttype;
	private String profileimageurl;
	
	public java.util.Date getLastAccessDate() {
		return lastaccessed;
	}
	
	public void setLastAccessDate(java.util.Date date){
		this.lastaccessed = date;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

	public String getAccountType() {
		return accounttype;
	}

	public void setAccountType(String accounttype){
		this.accounttype = accounttype;
	}
	public String getProfileImage() {
		return profileimageurl;
	}
	
	public void setProfileImage(String url){
		this.profileimageurl = url;
	}

}
