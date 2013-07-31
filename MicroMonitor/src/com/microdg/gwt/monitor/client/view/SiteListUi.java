package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.robaone.gwt.eventbus.client.widget.DynamicTableRowWidget;
import com.robaone.gwt.eventbus.client.widget.DynamicTableWidget;

public class SiteListUi extends Composite {

	private static SiteListUiUiBinder uiBinder = GWT
			.create(SiteListUiUiBinder.class);

	interface SiteListUiUiBinder extends UiBinder<Widget, SiteListUi> {
	}

	public SiteListUi() {
		initWidget(uiBinder.createAndBindUi(this));
		String[] header = {"Site Name","Client",""};
		siteTable.setHeaders(header);
		Widget[] row1 = new Widget[3];
		row1[0] = new Label("Site 1");
		row1[1] = new Label("Client 1");
		row1[2] = new Button("View");
		row1[2].getElement().setAttribute("onclick", "window.location = '#massexposure/sites/1'");
		row1[2].setStyleName("btn");
		DynamicTableRowWidget row = new DynamicTableRowWidget();
		row.setContent(row1);
		siteTable.appendRow(row);
	}

	@UiField
	DynamicTableWidget siteTable;


	

}
