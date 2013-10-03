package com.microdg.gwt.monitor.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.LoginRequiredException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.EmployeeDTO;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {

	boolean login(LoginInfoDTO message) throws SimpleException, FieldException;

	boolean logout();

	AppSessionDataDTO getSessionData() throws SimpleException;

	SiteDTO createNewSite(String sitename) throws SimpleException, FieldException, LoginRequiredException;

	SiteDTO getSiteInfo(int id) throws SimpleException, LoginRequiredException;

	KeywordDTO saveSiteKeyword(KeywordDTO message) throws SimpleException, FieldException, LoginRequiredException;

	KeywordDTO[] getSiteKeywords(int id) throws SimpleException, LoginRequiredException;

	ServiceAreaDTO[] getSiteServiceAreas(int id) throws SimpleException, LoginRequiredException;

	boolean recoverPassword(String email) throws SimpleException, FieldException;

	ClientDTO[] getClients() throws SimpleException, LoginRequiredException;

	ClientDTO saveClient(ClientDTO message) throws SimpleException, FieldException, LoginRequiredException;

	ClientDTO getClient(Integer clientId) throws SimpleException, LoginRequiredException;

	EmployeeDTO[] getClientEmployees(Integer clientId) throws SimpleException, LoginRequiredException;

	EmployeeDTO saveClientEmployee(EmployeeDTO message) throws SimpleException, FieldException, LoginRequiredException;

	EmployeeDTO getClientEmployee(int employeeId) throws SimpleException, LoginRequiredException;

}
