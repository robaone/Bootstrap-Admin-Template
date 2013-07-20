package com.microdg.gwt.monitor.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {

	boolean login(LoginInfoDTO message);

	boolean logout();

	AppSessionDataDTO getSessionData() throws SimpleException;

	SiteDTO createNewSite(String sitename);

	SiteDTO getSiteInfo(int id);

	KeywordDTO saveSiteKeyword(KeywordDTO message);

	KeywordDTO[] getSiteKeywords(int id);

}
