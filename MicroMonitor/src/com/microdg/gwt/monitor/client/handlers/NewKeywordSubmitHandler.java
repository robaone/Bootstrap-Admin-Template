package com.microdg.gwt.monitor.client.handlers;

import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class NewKeywordSubmitHandler implements SubmitHandler {

	private int m_siteid;
	private TextBox m_name;

	public NewKeywordSubmitHandler(int siteid, TextBox name_txt) {
		this.m_siteid = siteid;
		this.m_name = name_txt;
	}

	@Override
	public void onSubmit(SubmitEvent event) {
		KeywordDTO keyword = new KeywordDTO();
		keyword.setName(this.m_name.getText());
		keyword.setSiteId(this.m_siteid);
		EventBus.handleObjectEvent(new ObjectChannelEvent("site:save-keyword",keyword));
	}

}
