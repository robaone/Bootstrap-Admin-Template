package com.microdg.gwt.monitor.client.history;
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
		if("home".equalsIgnoreCase(page)){
			return new HomePageHandler();
		}else if("settings".equalsIgnoreCase(page)){
			return new SettingsPageHandler();
		}else if("dashboard".equalsIgnoreCase(page)){
			return new DashboardPageHandler();
		}else{
			throw new Exception("No match found");
		}
	}
}
