package com.microdg.gwt.monitor.server.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microdg.gwt.monitor.server.AppSessionHandlerTemplace;
import com.microdg.gwt.monitor.server.SessionData;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
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
public class AppSessionHandler implements AppSessionHandlerTemplace {

	private static final String SESSIONDATA = "sessiondata";

	public AppSessionHandler(SessionData sessionData) {
		// TODO Auto-generated constructor stub
	}

	public AppSessionHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AppSessionDataDTO getSessionData() throws SimpleException {
		AppSessionDataDTO data = new AppSessionDataDTO();
		data.setBrand("Test Site");
		data.setProfile(getUserProfile());
		return data;
	}

	private UserProfileDTO getUserProfile() {
		UserProfileDTO profile = new UserProfileDTO();
		profile.setAccountType("test");
		profile.setLastAccessDate(new java.util.Date());
		profile.setUsername("test user");
		return profile;
	}

	@Override
	public SessionData newSessionData() {
		SessionData data = new SessionData(){
			
		};
		return data;
	}

	@Override
	public SessionData initializeSession(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		SessionData sdata = (SessionData)session.getAttribute(SESSIONDATA);
		if(sdata == null){
			sdata = this.newSessionData();
			session.setAttribute(SESSIONDATA, sdata);
		}
		response.addCookie(new Cookie("accesstoken","234233242423442342342432"));
		return sdata;
	}

}
