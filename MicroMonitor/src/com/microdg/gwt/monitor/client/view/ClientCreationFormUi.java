package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.FieldErrorDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class ClientCreationFormUi extends EventDrivenComposite implements HasText {

	public static final String CLIENTCREATIONFORMUI = "clientcreationformui";
	private static ClientCreationFormUiUiBinder uiBinder = GWT
			.create(ClientCreationFormUiUiBinder.class);

	interface ClientCreationFormUiUiBinder extends
			UiBinder<Widget, ClientCreationFormUi> {
	}

	public ClientCreationFormUi() {
		initWidget(uiBinder.createAndBindUi(this));
		this.setChannels(CLIENTCREATIONFORMUI);
		this.bind();
	}
	Integer clientid;
	
	@UiField Button button;
	@UiField TextBox businessName;
	@UiField TextBox businessAddress;
	@UiField TextBox businessAddress2;
	@UiField TextBox businessCity;
	@UiField TextBox businessState;
	@UiField TextBox businessZip;
	@UiField VerticalPanel fieldErrors;

	public ClientCreationFormUi(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		this.fieldErrors.clear();
		ClientDTO client = new ClientDTO();
		client.setClientId(this.clientid);
		client.setName(businessName.getText());
		EventBus.handleObjectEvent(new ObjectChannelEvent("client:save",client));
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
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
		if(message instanceof ClientDTO){
			ClientDTO client = (ClientDTO)message;
			this.businessName.setText(client.getName());
			this.clientid = client.getClientId();
		}else if(message instanceof FieldErrorDTO){
			this.handleFieldErrors((FieldErrorDTO)message);
		}
	}

	private void handleFieldErrors(FieldErrorDTO message) {
		Label error = new Label("Error! " + message.getField() + ": " + message.getError());
		this.fieldErrors.add(error);
	}

}
