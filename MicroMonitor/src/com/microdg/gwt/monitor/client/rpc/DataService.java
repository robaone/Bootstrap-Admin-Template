package com.microdg.gwt.monitor.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {

	boolean login(LoginInfoDTO message) throws SimpleException, FieldException;

	boolean logout();

	AppSessionDataDTO getSessionData() throws SimpleException;

	SiteDTO createNewSite(String sitename) throws SimpleException, FieldException;

	SiteDTO getSiteInfo(int id);

	KeywordDTO saveSiteKeyword(KeywordDTO message) throws SimpleException, FieldException;

	KeywordDTO[] getSiteKeywords(int id);

	ServiceAreaDTO[] getSiteServiceAreas(int id);

	boolean recoverPassword(String email) throws SimpleException, FieldException;

	ClientDTO[] getClients() throws SimpleException;

	ClientDTO saveClient(ClientDTO message) throws SimpleException, FieldException;

}
