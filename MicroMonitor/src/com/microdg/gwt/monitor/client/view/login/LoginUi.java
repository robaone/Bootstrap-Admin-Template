package com.microdg.gwt.monitor.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.client.events.LoginInfoEvent;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.NativeChannelEvent;

public class LoginUi extends Composite {

	private static LoginUiUiBinder uiBinder = GWT.create(LoginUiUiBinder.class);

	interface LoginUiUiBinder extends UiBinder<Widget, LoginUi> {
	}

	public LoginUi() {
		initWidget(uiBinder.createAndBindUi(this));
		username.getElement().setAttribute("placeholder", "Username");
		password.getElement().setAttribute("placeholder", "Password");
		email.getElement().setAttribute("placeholder","mail@domain.com");
		email.getElement().setAttribute("required","required");
		recoverPassword.getElement().setAttribute("placeholder", "mail@domain.com");
		registerUsername.getElement().setAttribute("placeholder", "username");
		registerEmail.getElement().setAttribute("placeholder", "mail@domain.com");
		registerPassword.getElement().setAttribute("placeholder", "password");
	}

	@UiField TextBox username;
	@UiField PasswordTextBox password;
	@UiField Button submit;
	@UiField TextBox email;
	@UiField Button recoverPassword;
	@UiField TextBox registerUsername;
	@UiField TextBox registerEmail;
	@UiField PasswordTextBox registerPassword;
	@UiField Button registerSubmit;
	
	@UiHandler("submit")
	void onClick(ClickEvent e){
		String username_string = username.getText();
		String password_string = password.getText();
		LoginInfoDTO logininfo = new LoginInfoDTO();
		logininfo.setUsername(username_string);
		logininfo.setPassword(password_string);
		
		LoginInfoEvent event = new LoginInfoEvent("login",logininfo); 
		EventBus.handleNativeEvent(event);
	}

	@UiHandler("recoverPassword")
	void onRecoverClick(ClickEvent e){
		String email_string = email.getText();
		LoginInfoDTO logininfo = new LoginInfoDTO();
		logininfo.setEmail(email_string);
		
		LoginInfoEvent event = new LoginInfoEvent("recover-password",logininfo); 
		EventBus.handleNativeEvent(event);
	}

	@UiHandler("registerSubmit")
	void onRegisterClick(ClickEvent e){
		String email_string = registerEmail.getText();
		String username_string = registerUsername.getText();
		String password_string = registerPassword.getText();
		LoginInfoDTO logininfo = new LoginInfoDTO();
		logininfo.setEmail(email_string);
		logininfo.setPassword(password_string);
		logininfo.setUsername(username_string);
		
		LoginInfoEvent event = new LoginInfoEvent("register-user",logininfo); 
		EventBus.handleNativeEvent(event);
	}
}
