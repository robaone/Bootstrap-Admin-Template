package com.microdg.gwt.monitor.client.handlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.microdg.gwt.monitor.client.history.ApplicationHistoryHandler;
import com.microdg.gwt.monitor.client.history.ApplicationHistoryHandlerFactory;

public class CreateSiteHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			try {
				History.newItem("sites/new");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}