package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.microdg.gwt.monitor.shared.dto.EmployeeDTO;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.widget.DynamicTableRowWidget;
import com.robaone.gwt.eventbus.client.widget.DynamicTableWidget;

public class ClientViewUi extends EventDrivenComposite implements HasText {

	public static final String CLIENTVIEWUI = "clientviewui";
	private static ClientViewUiUiBinder uiBinder = GWT
			.create(ClientViewUiUiBinder.class);

	interface ClientViewUiUiBinder extends UiBinder<Widget, ClientViewUi> {
	}

	public ClientViewUi() {
		initWidget(uiBinder.createAndBindUi(this));
		this.setChannels(ClientViewUi.CLIENTVIEWUI);
		String[] headers = {"Employee Name","Email Address","Role(s)",""};
		employeeList.setHeaders(headers);
		employeeList.setWidth("100%");
		bind();
	}
	private ClientDTO client;
	@UiField
	Button button;
	@UiField InlineLabel name;
	@UiField DynamicTableWidget employeeList;
	@UiField Button createEmployee;
	@UiHandler("button")
	void onClick(ClickEvent e) {
		History.newItem("massexposure/clients");
	}
	@UiHandler("createEmployee")
	void onCreateEmployeeClick(ClickEvent e){
		History.newItem("massexposure/clients/"+this.client.getClientId()+"/employee/new");
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
			setClient((ClientDTO)message);
		}else if(message instanceof EmployeeDTO[]){
			setEmployees((EmployeeDTO[])message);
		}
	}

	private void setEmployees(EmployeeDTO[] message) {
		employeeList.clear();
		for(int i = 0; i < message.length;i++){
			DynamicTableRowWidget row = new DynamicTableRowWidget();
			Widget[] rowContents = new Widget[4];
			rowContents[0] = new Label(message[i].getName());
			rowContents[1] = new Label(message[i].getEmailAddress());
			rowContents[2] = new Label(formatRoles(message[i].getRoles()));
			rowContents[3] = new Button("View");
			row.setContent(rowContents);
			employeeList.appendRow(row);
		}
	}
	protected String formatRoles(String[] roles) {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < roles.length;i++){
			if(i > 0){
				buffer.append(",");
			}
			buffer.append(roles[i]);
		}
		return buffer.toString();
	}
	private void setClient(ClientDTO message) {
		if(this.client != null && this.client.getClientId() != message.getClientId()){
			this.employeeList.clear();
		}
		this.client = message;
		this.name.setText(this.client.getName());
	}

}
