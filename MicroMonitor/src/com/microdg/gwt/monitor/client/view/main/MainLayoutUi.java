package com.microdg.gwt.monitor.client.view.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class MainLayoutUi extends Composite {

	private static MainLayoutUiUiBinder uiBinder = GWT
			.create(MainLayoutUiUiBinder.class);

	interface MainLayoutUiUiBinder extends UiBinder<Widget, MainLayoutUi> {
	}

	@UiField Anchor brand;
	@UiField InlineLabel pagename;
	
	public MainLayoutUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public void setBrand(String string) {
		this.brand.setText(string);
	}
	public void setPageName(String string) {
		pagename.setText(string);
	}

}
