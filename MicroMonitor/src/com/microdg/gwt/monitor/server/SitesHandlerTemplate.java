package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public interface SitesHandlerTemplate {

	SiteDTO createNewSite(String sitename);

	SiteDTO getSiteInfo(int id);

}
