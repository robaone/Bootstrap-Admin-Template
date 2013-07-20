package com.microdg.gwt.monitor.client.handlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.microdg.gwt.monitor.client.history.ApplicationHistoryHandler;
import com.microdg.gwt.monitor.client.history.ApplicationHistoryHandlerFactory;

public class CreateSiteHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			try {
				ApplicationHistoryHandler handler = ApplicationHistoryHandlerFactory.newInstance("sites");
				String[] parsed = {"sites","new"};
				handler.handle(parsed);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}