package com.microdg.gwt.monitor.client.control;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.view.main.MainLayoutUi;
import com.microdg.gwt.monitor.shared.dto.UserProfileDTO;

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
public class ApplicationProfileHandler implements ApplicationEventHandler {
	DateTimeFormat df;
	public ApplicationProfileHandler(){
		df = DateTimeFormat.getFormat("MM/dd/yy hh:mm a");
	}
	@Override
	public void handle(Object message) {
		UserProfileDTO profile = (UserProfileDTO)message;
		MainLayoutUi layout = MicroMonitor.getMainLayoutUi();
		layout.setLastAccessDate(format(profile.getLastAccessDate()));
		layout.setUsername(profile.getUsername());
		layout.setAccountType(profile.getAccountType());
		layout.setProfileImage(profile.getProfileImage());
	}

	protected String format(Date lastAccessDate) {
		return df.format(lastAccessDate);
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		MainLayoutUi layout = MicroMonitor.getMainLayoutUi();
		String lastaccessdate = this.getLastAccessDate(message);
		String username = this.getUsername(message);
		String accounttype = this.getAccountType(message);
		String profileimage = this.getProfileImage(message);
		if(lastaccessdate != null){
			layout.setLastAccessDate(lastaccessdate);
		}
		if(username != null){
			layout.setUsername(username);
		}
		if(accounttype != null){
			layout.setAccountType(accounttype);
		}
		if(profileimage != null){
			layout.setProfileImage(profileimage);
		}
	}
	private native String getProfileImage(JavaScriptObject message) /*-{
		try{
			return message.profileimage;
		}catch(Exception){
			return null;
		}
	}-*/;
	private native String getUsername(JavaScriptObject message) /*-{
		try{
			return message.username;
		}catch(Exception){
			return null;
		}
	}-*/;
	private native String getAccountType(JavaScriptObject message) /*-{
		try{
			return message.accounttype;
		}catch(Exception){
			return null;
		}
	}-*/;
	private native String getLastAccessDate(JavaScriptObject message) /*-{
		try{
			return message.lastaccessdate;
		}catch(Exception){
			return null;
		}
	}-*/;

}
