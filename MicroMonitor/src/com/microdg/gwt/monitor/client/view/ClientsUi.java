package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

public class ClientsUi extends Composite implements HasText {

	private static ClientsUiUiBinder uiBinder = GWT
			.create(ClientsUiUiBinder.class);

	interface ClientsUiUiBinder extends UiBinder<Widget, ClientsUi> {
	}

	public ClientsUi() {
		initWidget(uiBinder.createAndBindUi(this));
		String[] headers = {"Client Name","Type",""};
		this.clientTable.setHeaders(headers);
		Widget[] row1 = new Widget[2];
		row1[0] = new Label("Client 1");
		Button b = new Button("View");
		b.setStyleName("btn");
		b.getElement().setAttribute("onclick", "window.location = '#massexposure/clients/1'");
		row1[1] = b;
		DynamicTableRowWidget row = new DynamicTableRowWidget();
		row.setContent(row1);
		clientTable.appendRow(row);
	}

	@UiField Button button;
	@UiField DynamicTableWidget clientTable;

	public ClientsUi(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		History.newItem("massexposure/clients/new");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}
