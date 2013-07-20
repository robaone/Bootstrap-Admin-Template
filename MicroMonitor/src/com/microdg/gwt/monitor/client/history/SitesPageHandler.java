package com.microdg.gwt.monitor.client.history;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class SitesPageHandler implements ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Sites"));
		EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayoutUi());
		if(parsed.length > 1){
			if(parsed[1].equalsIgnoreCase("new")){
				renderNewSiteForm();
			}
		}
	}

	private void renderNewSiteForm() {
		FlowPanel panel = new FlowPanel();
		Label title = new Label("New Site");
		panel.add(title);
		FormPanel form = new FormPanel();
		form.setStyleName("form");
		panel.add(form);
		InlineLabel name = new InlineLabel("Site Name");
		FlowPanel form_contents = new FlowPanel();
		form_contents.add(name);
		form.add(form_contents);
		TextBox name_txt = new TextBox();
		form_contents.add(name_txt);
		Button submit = new Button("Submit");
		submit.setStyleName("btn btn-primary");
		form_contents.add(submit);
		
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, panel);
	}

}
