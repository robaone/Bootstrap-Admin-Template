package com.microdg.gwt.monitor.client.handlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;

public class CreateServiceAreaForSite implements ClickHandler {

	private SiteDTO site;

	public CreateServiceAreaForSite(SiteDTO message) {
		this.site = message;
	}

	@Override
	public void onClick(ClickEvent event) {
		History.newItem("sites/view/1/servicearea/new");
	}

}
