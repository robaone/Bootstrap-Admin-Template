package com.microdg.gwt.monitor.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.FieldError;
import com.microdg.gwt.monitor.shared.dto.GeneralError;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class LoginUi extends EventDrivenComposite {

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
	@UiField HTMLPanel loginError;
	@UiField HTMLPanel generalError;
	@UiField HTMLPanel usernameError;
	@UiField HTMLPanel passwordError;
	@UiField InlineLabel generalErrorText;
	@UiField InlineLabel usernameErrorText;
	@UiField InlineLabel passwordErrorText;
	
	@UiHandler("submit")
	void onClick(ClickEvent e){
		String username_string = username.getText();
		String password_string = password.getText();
		LoginInfoDTO logininfo = new LoginInfoDTO();
		logininfo.setUsername(username_string);
		logininfo.setPassword(password_string);
		
		ObjectChannelEvent event = new ObjectChannelEvent("login",logininfo); 
		EventBus.handleObjectEvent(event);
	}

	@UiHandler("recoverPassword")
	void onRecoverClick(ClickEvent e){
		String email_string = email.getText();
		LoginInfoDTO logininfo = new LoginInfoDTO();
		logininfo.setEmail(email_string);
		
		ObjectChannelEvent event = new ObjectChannelEvent("recover-password",logininfo); 
		EventBus.handleObjectEvent(event);
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
		
		ObjectChannelEvent event = new ObjectChannelEvent("register-user",logininfo); 
		EventBus.handleObjectEvent(event);
	}

	@Override
	public void handleEvent(String command, Widget message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEvent(JavaScriptObject message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEvent(String command, Widget[] messages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleObjectEvent(Object message) {
		if(message instanceof GeneralError){
			handleError((GeneralError)message);
		}else if(message instanceof FieldError){
			handleError((FieldError)message);
		}
	}

	private void handleError(FieldError message) {
		if("username".equalsIgnoreCase(message.getFieldName())){
			this.usernameError.setVisible(true);
			this.usernameErrorText.setText(message.getError());
		}else if("password".equalsIgnoreCase(message.getFieldName())){
			this.passwordError.setVisible(true);
			this.passwordErrorText.setText(message.getError());
		}
	}

	private void handleError(GeneralError error) {
		this.generalError.setVisible(true);
		this.generalErrorText.setText(error.getError());
	}
}
