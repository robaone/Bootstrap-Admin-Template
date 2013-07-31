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
import com.google.gwt.user.client.ui.Widget;

public class ClientViewUi extends Composite implements HasText {

	private static ClientViewUiUiBinder uiBinder = GWT
			.create(ClientViewUiUiBinder.class);

	interface ClientViewUiUiBinder extends UiBinder<Widget, ClientViewUi> {
	}

	public ClientViewUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public ClientViewUi(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		History.newItem("massexposure/clients");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}
