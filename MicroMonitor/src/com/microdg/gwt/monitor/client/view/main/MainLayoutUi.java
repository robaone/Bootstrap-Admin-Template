package com.microdg.gwt.monitor.client.view.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.UIObject;

public class MainLayoutUi extends UIObject {

	private static MainLayoutUiUiBinder uiBinder = GWT
			.create(MainLayoutUiUiBinder.class);

	interface MainLayoutUiUiBinder extends UiBinder<Element, MainLayoutUi> {
	}

	
	public MainLayoutUi() {
		setElement(uiBinder.createAndBindUi(this));
	}

}
