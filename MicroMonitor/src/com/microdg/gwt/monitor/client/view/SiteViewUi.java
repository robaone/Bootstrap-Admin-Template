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

public class SiteViewUi extends Composite implements HasText {

	private static SiteViewUiUiBinder uiBinder = GWT
			.create(SiteViewUiUiBinder.class);

	interface SiteViewUiUiBinder extends UiBinder<Widget, SiteViewUi> {
	}

	public SiteViewUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public SiteViewUi(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		History.newItem("massexposure/sites");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}
