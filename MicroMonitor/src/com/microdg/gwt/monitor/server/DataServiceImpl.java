package com.microdg.gwt.monitor.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.microdg.gwt.monitor.client.rpc.DataService;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public class DataServiceImpl extends RemoteServiceServlet implements DataService {

	private static final long serialVersionUID = 4710522469154611397L;

	@Override
	public boolean login(LoginInfoDTO message) {
		LoginHandlerTemplate handler = HandlerFactory.newLoginHandler();
		return handler.login(message);
	}

	@Override
	public boolean logout() {
		LogoutHandlerTemplate handler = HandlerFactory.newLogoutHandler();
		return handler.logout();
	}

	@Override
	public AppSessionDataDTO getSessionData() throws SimpleException {
		AppSessionHandlerTemplace handler = HandlerFactory.newAppSessionHandler();
		return handler.getSessionData();
	}

	@Override
	public SiteDTO createNewSite(String sitename) {
		SitesHandlerTemplate handler = HandlerFactory.newSitesHandler();
		return handler.createNewSite(sitename);
	}

	@Override
	public SiteDTO getSiteInfo(int id) {
		SitesHandlerTemplate handler = HandlerFactory.newSitesHandler();
		return handler.getSiteInfo(id);
	}

	@Override
	public KeywordDTO saveSiteKeyword(KeywordDTO message) {
		KeywordHandlerTemplate handler = HandlerFactory.newKeywordHandler();
		return handler.saveSiteKeyword(message);
	}

	@Override
	public KeywordDTO[] getSiteKeywords(int id) {
		KeywordHandlerTemplate handler = HandlerFactory.newKeywordHandler();
		return handler.getSiteKeywords(id);
	}

}
