package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.EmployeeDTO;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

/**
 * <pre>   Copyright 2013 Ansel Robateau
         http://www.robaone.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.</pre>
 * @author Ansel
 *
 */
public class ClientEmployeeEditFormUi extends EventDrivenComposite {
	public static String CLIENTEMPLOYEEEDITFORMUI = "clientemployeeeditformui";
	private static ClientEmployeeEditFormUiUiBinder uiBinder = GWT
			.create(ClientEmployeeEditFormUiUiBinder.class);

	interface ClientEmployeeEditFormUiUiBinder extends
			UiBinder<Widget, ClientEmployeeEditFormUi> {
	}

	public ClientEmployeeEditFormUi() {
		initWidget(uiBinder.createAndBindUi(this));
		this.setChannels(CLIENTEMPLOYEEEDITFORMUI);
		bind();
	}

	@UiField
	Button button;
	@UiField TextBox employeeName;
	@UiField TextBox employeeEmailAddr;
	private ClientDTO client;
	private EmployeeDTO employee;


	@UiHandler("button")
	void onClick(ClickEvent e) {
		EmployeeDTO employee = getEmployee();
		employee.setName(this.employeeName.getText());
		employee.setEmailAddress(this.employeeEmailAddr.getText());
		employee.setRoles(this.getRoles());
		employee.setClientId(client.getClientId());
		EventBus.handleObjectEvent(new ObjectChannelEvent("client:save-employee",employee));
	}


	private EmployeeDTO getEmployee() {
		if(employee == null){
			return new EmployeeDTO();
		}else{
			return employee;
		}
	}


	private String[] getRoles() {
		// TODO Auto-generated method stub
		return null;
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
		if(message instanceof EmployeeDTO){
			this.setEmployee((EmployeeDTO) message);
		}else if(message instanceof ClientDTO){
			this.setClient((ClientDTO)message);
		}
	}


	private void setClient(ClientDTO message) {
		this.client = message;
	}
	
	protected ClientDTO getClient(){
		return this.client;
	}


	private void setEmployee(EmployeeDTO message) {
		this.employeeName.setText(message.getName());
		this.employeeEmailAddr.setText(message.getEmailAddress());
		this.employee = message;
	}

}
