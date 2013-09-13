package com.microdg.gwt.monitor.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.microdg.gwt.monitor.client.callback.CreateNewSiteCallback;
import com.microdg.gwt.monitor.client.callback.GetKeywordsCallback;
import com.microdg.gwt.monitor.client.callback.GetServceAreasCallback;
import com.microdg.gwt.monitor.client.callback.InitilizeCalback;
import com.microdg.gwt.monitor.client.callback.SaveKeywordCallback;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.EmployeeDTO;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public interface DataServiceAsync {

	void login(LoginInfoDTO message,AsyncCallback<Boolean> response);

	void logout(AsyncCallback<Boolean> asyncCallback);
	
	void recoverPassword(String email, AsyncCallback<Boolean> asyncCallback);

	void getSessionData(AsyncCallback<AppSessionDataDTO> initilizeCalback);

	void createNewSite(String sitename,
			AsyncCallback<SiteDTO> createNewSiteCallback);

	void getSiteInfo(int id, AsyncCallback<SiteDTO> getSiteInfo);

	void saveSiteKeyword(KeywordDTO message,
			AsyncCallback<KeywordDTO> saveKeywordCallback);

	void getSiteKeywords(int id, AsyncCallback<KeywordDTO[]> getKeywordsCallback);

	void getSiteServiceAreas(int id,
			AsyncCallback<ServiceAreaDTO[]> getServceAreasCallback);

	void getClients(AsyncCallback<ClientDTO[]> asyncCallback);

	void saveClient(ClientDTO message, AsyncCallback<ClientDTO> asyncCallback);

	void getClient(Integer clientId, AsyncCallback<ClientDTO> asyncCallback);

	void getClientEmployees(Integer clientId,
			AsyncCallback<EmployeeDTO[]> asyncCallback);

	void saveClientEmployee(EmployeeDTO message,
			AsyncCallback<EmployeeDTO> asyncCallback);

	void getClientEmployee(int employeeId,
			AsyncCallback<EmployeeDTO> asyncCallback);

}
