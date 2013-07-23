package com.microdg.gwt.monitor.client.history;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.handlers.CreateSiteHandler;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;
import com.robaone.gwt.eventbus.client.widget.DynamicTableWidget;

/**
 * <pre>   Copyright 2013 Ansel Robateau
         http://www.robaone.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.</pre>
 * @author Ansel
 *
 */
public class HomePageHandler implements ApplicationHistoryHandler {

	

	@Override
	public void handle(String[] parsed) {
		EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayoutUi());
		Button add = new Button("Build New Site");
		add.setStyleName("btn btn-primary");
		add.addClickHandler(new CreateSiteHandler());
		FlowPanel vp = new FlowPanel();
		vp.setWidth("100%");
		vp.setHeight("400px");
		vp.add(add);
		DynamicTableWidget table = new DynamicTableWidget();
		table.setStyleName("table");
		vp.add(table);
		String[] headers = {"Site Name","Action"};
		table.setHeaders(headers);
		MicroMonitor.getMainLayoutUi().getContentPanel().clear();
		MicroMonitor.getMainLayoutUi().getContentPanel().add(vp);
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Home"));
	}

}
