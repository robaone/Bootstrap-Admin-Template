package com.microdg.gwt.monitor.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.FieldErrorDTO;
import com.microdg.gwt.monitor.shared.dto.GeneralErrorDTO;
import com.microdg.gwt.monitor.shared.dto.LoginInfoDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class LoginUi extends EventDrivenComposite {

	public static final String LOGINUI = "loginui";
	public static final String PASSWORDRESETUI = "passwordresetui";
	private static LoginUiUiBinder uiBinder = GWT.create(LoginUiUiBinder.class);

	interface LoginUiUiBinder extends UiBinder<Widget, LoginUi> {
	}

	public LoginUi() {
		this.setChannels(LOGINUI+" "+PASSWORDRESETUI);
		initWidget(uiBinder.createAndBindUi(this));
		username.getElement().setAttribute("placeholder", "Username");
		password.getElement().setAttribute("placeholder", "Password");
		email.getElement().setAttribute("placeholder","mail@domain.com");
		email.getElement().setAttribute("required","required");
		recoverPassword.getElement().setAttribute("placeholder", "mail@domain.com");
		registerUsername.getElement().setAttribute("placeholder", "username");
		registerEmail.getElement().setAttribute("placeholder", "mail@domain.com");
		registerPassword.getElement().setAttribute("placeholder", "password");
		bind();
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
	@UiField HTMLPanel passwordResetError;
	@UiField HTMLPanel generalError;
	@UiField HTMLPanel generalEmailError;
	@UiField HTMLPanel usernameError;
	@UiField HTMLPanel emailError;
	@UiField HTMLPanel passwordError;
	@UiField InlineLabel generalErrorText;
	@UiField InlineLabel usernameErrorText;
	@UiField InlineLabel passwordErrorText;
	@UiField InlineLabel generalEmailErrorText;
	@UiField InlineLabel emailErrorText;
	private String currentChannel;
	
	@UiHandler("submit")
	void onClick(ClickEvent e){
		this.hideErrors();
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
		this.hideErrors();
		String email_string = email.getText();
		
		ObjectChannelEvent event = new ObjectChannelEvent("recover-password",email_string); 
		EventBus.handleObjectEvent(event);
	}

	@UiHandler("registerSubmit")
	void onRegisterClick(ClickEvent e){
		this.hideErrors();
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
	protected boolean inChannel(String channel){
		boolean retval = super.inChannel(channel);
		if(retval){
			this.setCurrentChannel(channel);
		}
		return retval;
	}

	private void setCurrentChannel(String channel) {
		this.currentChannel = channel;
	}
	
	protected String getCurrentChannel(){
		return this.currentChannel;
	}

	@Override
	public void handleObjectEvent(Object message) {
		if(message instanceof GeneralErrorDTO){
			showErrors();
			handleError((GeneralErrorDTO)message);
		}else if(message instanceof FieldErrorDTO){
			showErrors();
			handleError((FieldErrorDTO)message);
		}
	}

	private void showErrors() {
		if(LoginUi.LOGINUI.equalsIgnoreCase(getCurrentChannel())){
			this.loginError.setVisible(true);
		}else if(LoginUi.PASSWORDRESETUI.equalsIgnoreCase(getCurrentChannel())){
			this.passwordResetError.setVisible(true);
		}
		
	}
	
	private void hideErrors() {
		this.loginError.setVisible(false);
		this.generalError.setVisible(false);
		this.usernameError.setVisible(false);
		this.passwordError.setVisible(false);
		this.passwordResetError.setVisible(false);
		this.generalEmailError.setVisible(false);
		this.emailError.setVisible(false);
	}

	private void handleError(FieldErrorDTO message) {
		if("username".equalsIgnoreCase(message.getField())){
			this.usernameError.setVisible(true);
			this.usernameErrorText.setText(message.getError());
		}else if("password".equalsIgnoreCase(message.getField())){
			this.passwordError.setVisible(true);
			this.passwordErrorText.setText(message.getError());
		}else if("email".equalsIgnoreCase(message.getField())){
			this.emailError.setVisible(true);
			this.emailErrorText.setText(message.getError());
		}
	}

	private void handleError(GeneralErrorDTO error) {
		if(LOGINUI.equalsIgnoreCase(this.getCurrentChannel())){
			this.generalError.setVisible(true);
			this.generalErrorText.setText(error.getError());
		}else if(PASSWORDRESETUI.equalsIgnoreCase(this.getCurrentChannel())){
			this.handleResetError(error);
		}
	}
	
	private void handleResetError(GeneralErrorDTO error){
		this.generalEmailError.setVisible(true);
		this.generalEmailErrorText.setText(error.getError());
	}
}
