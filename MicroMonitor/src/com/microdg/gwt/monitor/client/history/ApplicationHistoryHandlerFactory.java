package com.microdg.gwt.monitor.client.history;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;

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
public class ApplicationHistoryHandlerFactory {
	public static ApplicationHistoryHandler newInstance(String page) throws Exception{
		System.out.println(ApplicationHistoryHandler.class.getName() + ": "+ page);
		if(MicroMonitor.getAppSessionData() != null){
			if(MicroMonitor.getAppSessionData().getProfile() == null){
				return new LoginPageHandler();
			}else{
				if("home".equalsIgnoreCase(page)){
					return new HomePageHandler();
				}else if("settings".equalsIgnoreCase(page)){
					return new SettingsPageHandler();
				}else if("dashboard".equalsIgnoreCase(page)){
					return new DashboardPageHandler();
				}else if("massexposure".equalsIgnoreCase(page)){
					return new MassExposurePageHandler();
				}else if("massexposure/clients/new".equalsIgnoreCase(page)){
					return new NewMassExposureClientPageHandler();
				}else if("massexposure/clients".equalsIgnoreCase(page)){
					return new MassExposureClientsPageHandler();
				}else if("massexposure/sites".equalsIgnoreCase(page)){
					return new MassExposureSitesPageHandler();
				}else if(MassExposureClientViewHandler.is(page)){
					return new MassExposureClientViewHandler();
				}else if(MassExposureClientEmployeeViewHandler.is(page)){
					return new MassExposureClientEmployeeViewHandler();
				}else if(MassExposureClientNewEmployeeHandler.is(page)){
					return new MassExposureClientNewEmployeeHandler();
				}else if(MassExposureClientEditEmployeeHandler.is(page)){
					return new MassExposureClientEditEmployeeHandler();
				}else if(MassExposureSiteViewHandler.is(page)){
					return new MassExposureSiteViewHandler();
				}else{
					throw new Exception("No match found");
				}
			}
		}else{
			throw new Exception("getsessiondata");
		}
	}

}
