package com.microdg.gwt.monitor.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.microdg.gwt.monitor.client.rpc.DataService;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public class DataServiceImpl extends RemoteServiceServlet implements DataService {

	private static final long serialVersionUID = 4710522469154611397L;
	public static final String SESSIONDATA = "sessiondata";
	private SessionData getSessionDataObject(){
		AppSessionHandlerTemplace handler = HandlerFactory.newAppSessionHandler();
		SessionData sdata = handler.initializeSession(this.perThreadRequest.get(),this.perThreadResponse.get());
		return sdata;
	}
	@Override
	public boolean login(LoginInfoDTO message) throws SimpleException, FieldException{
		LoginHandlerTemplate handler = HandlerFactory.newLoginHandler(this.getSessionDataObject());
		return handler.login(message);
	}

	@Override
	public boolean logout() {
		LogoutHandlerTemplate handler = HandlerFactory.newLogoutHandler(this.getSessionDataObject());
		return handler.logout();
	}

	@Override
	public AppSessionDataDTO getSessionData() throws SimpleException {
		AppSessionHandlerTemplace handler = HandlerFactory.newAppSessionHandler(this.getSessionDataObject());
		return handler.getSessionData();
	}

	@Override
	public SiteDTO createNewSite(String sitename) throws SimpleException, FieldException {
		SitesHandlerTemplate handler = HandlerFactory.newSitesHandler(this.getSessionDataObject());
		return handler.createNewSite(sitename);
	}

	@Override
	public SiteDTO getSiteInfo(int id) {
		SitesHandlerTemplate handler = HandlerFactory.newSitesHandler(this.getSessionDataObject());
		return handler.getSiteInfo(id);
	}

	@Override
	public KeywordDTO saveSiteKeyword(KeywordDTO message) throws SimpleException, FieldException {
		KeywordHandlerTemplate handler = HandlerFactory.newKeywordHandler(this.getSessionDataObject());
		return handler.saveSiteKeyword(message);
	}

	@Override
	public KeywordDTO[] getSiteKeywords(int id) {
		KeywordHandlerTemplate handler = HandlerFactory.newKeywordHandler(this.getSessionDataObject());
		return handler.getSiteKeywords(id);
	}

	@Override
	public ServiceAreaDTO[] getSiteServiceAreas(int id) {
		ServiceAreaHandlerTemplate handler = HandlerFactory.newServiceAreaHandler(this.getSessionDataObject());
		return handler.getSiteServiceAreas(id);
	}
	@Override
	public boolean recoverPassword(String email) throws SimpleException,
			FieldException {
		RecoverPasswordHandlerTemplate handler = HandlerFactory.newRecoverPasswordHandler(this.getSessionDataObject());
		return handler.recoverPassword(email);
	}
	@Override
	public ClientDTO[] getClients() throws SimpleException {
		ClientHandlerTemplate handler = HandlerFactory.newClientHandler(this.getSessionDataObject());
		return handler.getClients();
	}
	@Override
	public ClientDTO saveClient(ClientDTO message) throws SimpleException,
			FieldException {
		ClientHandlerTemplate handler = HandlerFactory.newClientHandler(this.getSessionDataObject());
		return handler.saveClient(message);
	}

}
