package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public interface SitesHandlerTemplate {

	SiteDTO createNewSite(String sitename) throws SimpleException, FieldException;

	SiteDTO getSiteInfo(int id);

}
