package com.microdg.gwt.monitor.client.handlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public class CreateKeywordForSite implements ClickHandler {

	private SiteDTO m_site;

	public CreateKeywordForSite(SiteDTO message) {
		this.m_site = message;
	}

	@Override
	public void onClick(ClickEvent event) {
		History.newItem("sites/view/"+this.m_site.getId()+"/keyword/new");
	}

}
