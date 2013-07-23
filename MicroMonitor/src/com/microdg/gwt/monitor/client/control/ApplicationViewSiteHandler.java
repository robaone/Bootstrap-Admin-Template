package com.microdg.gwt.monitor.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.microdg.gwt.monitor.client.handlers.CreateKeywordForSite;
import com.microdg.gwt.monitor.client.handlers.CreateServiceAreaForSite;
import com.microdg.gwt.monitor.client.view.KeywordsTable;
import com.microdg.gwt.monitor.client.view.ServiceAreaTable;
import com.microdg.gwt.monitor.shared.dto.SiteDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class ApplicationViewSiteHandler implements ApplicationEventHandler<SiteDTO> {

	@Override
	public void handle(SiteDTO message) {
		History.newItem("sites/view/"+message.getId(), false);
		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("100%");
		vp.add(new Label("Site: " + message.getName()));
		FlowPanel keywords = createKeywordsView(message);
		FlowPanel servicearea = createServiceAreaView(message);
		HorizontalPanel hp = new HorizontalPanel();
		hp.setWidth("100%");
		hp.add(keywords);
		hp.add(servicearea);
		vp.add(hp);
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, vp);
	}

	private FlowPanel createServiceAreaView(SiteDTO message) {
		FlowPanel flow = new FlowPanel();
		Button newservicearea = new Button("New Service Area");
		newservicearea.setStyleName("btn btn-primary");
		newservicearea.addClickHandler(new CreateServiceAreaForSite(message));
		flow.add(newservicearea);
		ServiceAreaTable table = new ServiceAreaTable();
		table.setChannels("servicearea-table");
		flow.add(table);
		EventBus.handleObjectEvent(new ObjectChannelEvent("site:load-serviceareas",message));
		return flow;
	}

	private FlowPanel createKeywordsView(SiteDTO message) {
		FlowPanel flow = new FlowPanel();
		Button newkeyword = new Button("New Keyword");
		newkeyword.setStyleName("btn btn-primary");
		newkeyword.addClickHandler(new CreateKeywordForSite(message));
		flow.add(newkeyword);
		KeywordsTable table = new KeywordsTable();
		table.setChannels("keywords-table");
		flow.add(table);
		EventBus.handleObjectEvent(new ObjectChannelEvent("site:load-keywords",message));
		return flow;
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
