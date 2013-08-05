package com.microdg.gwt.monitor.server.impl;

import com.microdg.gwt.monitor.server.SessionData;
import com.microdg.gwt.monitor.server.SitesHandlerTemplate;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public class SitesHandler implements SitesHandlerTemplate {

	public SitesHandler(SessionData sessionData) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SiteDTO createNewSite(String sitename) {
		SiteDTO site = new SiteDTO();
		site.setName(sitename);
		site.setId(1);
		return site;
	}

	@Override
	public SiteDTO getSiteInfo(int id) {
		SiteDTO site = new SiteDTO();
		site.setName("Stored test site");
		site.setId(id);
		return site;
	}

}
