package com.microdg.gwt.monitor.client.view.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class MainLayoutUi extends Composite {

	private static MainLayoutUiUiBinder uiBinder = GWT
			.create(MainLayoutUiUiBinder.class);

	interface MainLayoutUiUiBinder extends UiBinder<Widget, MainLayoutUi> {
	}

	@UiField Anchor brand;
	@UiField InlineLabel pagename;
	@UiField InlineLabel userAlertCount;
	@UiField InlineLabel username;
	@UiField InlineLabel accounttype;
	@UiField InlineLabel lastAccessDate;
	@UiField Image profileImage;
	@UiField SimplePanel content;
	
	public MainLayoutUi() {
		initWidget(uiBinder.createAndBindUi(this));
		profileImage.setAltText("User");
		profileImage.setUrl("micromonitor/assets/img/user.gif");
		brand.setHref("#home");
	}
	public void setBrand(String string) {
		this.brand.setText(string);
	}
	public void setPageName(String string) {
		pagename.setText(string);
	}
	public void setUsername(String name) {
		username.setText(name);
	}
	public void setAccountType(String type) {
		accounttype.setText(type);
	}
	public void setUserAlertCount(String count) {
		userAlertCount.setText(count);
	}
	public void setUserAlertCount(int count) {
		setUserAlertCount(""+count);
	}
	public void setLastAccessDate(String date) {
		lastAccessDate.setText(date);
	}
	public void setProfileImage(String url) {
		profileImage.setUrl(url);
	}
	public SimplePanel getContentPanel() {
		return this.content;
	}
}
