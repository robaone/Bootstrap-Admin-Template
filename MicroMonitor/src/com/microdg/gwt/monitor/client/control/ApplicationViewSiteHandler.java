package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.microdg.gwt.monitor.client.handlers.CreateKeywordForSite;
import com.microdg.gwt.monitor.client.view.KeywordsTable;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class ApplicationViewSiteHandler implements ApplicationEventHandler<SiteDTO> {

	@Override
	public void handle(SiteDTO message) {
		History.newItem("sites/view/"+message.getId(), false);
		FlowPanel flow = new FlowPanel();
		flow.add(new Label("Site: " + message.getName()));
		Button newkeyword = new Button("New Keyword");
		newkeyword.setStyleName("btn btn-primary");
		newkeyword.addClickHandler(new CreateKeywordForSite(message));
		flow.add(newkeyword);
		KeywordsTable table = new KeywordsTable();
		table.setChannels("keywords-table");
		flow.add(table);
		EventBus.handleObjectEvent(new ObjectChannelEvent("site:load-keywords",message));
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, flow);
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
