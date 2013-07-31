package com.microdg.gwt.monitor.client.handlers;

import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class NewServiceAreaSubmitHandler implements SubmitHandler {

	private TextBox name;

	public NewServiceAreaSubmitHandler(int parseInt, TextBox name_txt) {
		this.name = name_txt;
	}

	@Override
	public void onSubmit(SubmitEvent event) {
		ServiceAreaDTO area = new ServiceAreaDTO();
		area.setCity(this.name.getText());
		EventBus.handleObjectEvent(new ObjectChannelEvent("site:save-servicearea",area));
	}

}
