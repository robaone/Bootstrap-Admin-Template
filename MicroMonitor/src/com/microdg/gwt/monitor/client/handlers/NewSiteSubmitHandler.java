package com.microdg.gwt.monitor.client.handlers;

import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class NewSiteSubmitHandler implements SubmitHandler {

	private TextBox m_name;

	public NewSiteSubmitHandler(TextBox name_txt) {
		this.m_name = name_txt;
	}

	@Override
	public void onSubmit(SubmitEvent event) {
		String sitename = m_name.getText();
		EventBus.handleObjectEvent(new ObjectChannelEvent("site:create-new",sitename));
	}

}
