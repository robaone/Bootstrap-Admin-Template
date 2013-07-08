package com.microdg.gwt.monitor.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;

public class LoginUi extends Composite {

	private static LoginUiUiBinder uiBinder = GWT.create(LoginUiUiBinder.class);

	interface LoginUiUiBinder extends UiBinder<Widget, LoginUi> {
	}

	public LoginUi() {
		initWidget(uiBinder.createAndBindUi(this));
		username.getElement().setAttribute("placeholder", "Username");
		password.getElement().setAttribute("placeholder", "Password");
	}

	@UiField TextBox username;
	@UiField PasswordTextBox password;
	@UiField Button submit;
	
	@UiHandler("submit")
	void onClick(ClickEvent e){
		String username_string = username.getText();
		String password_string = password.getText();
		LoginInfoDTO logininfo = new LoginInfoDTO();
		logininfo.setUsername(username_string);
		logininfo.setPassword(password_string);
		
		
	}
}