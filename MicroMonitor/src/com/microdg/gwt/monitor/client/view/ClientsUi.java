package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.client.jo.ClientJO;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.widget.DynamicTableRowWidget;
import com.robaone.gwt.eventbus.client.widget.DynamicTableWidget;

public class ClientsUi extends EventDrivenComposite implements HasText {
	public static final String CLIENTSUI = "clientsui";
	private static ClientsUiUiBinder uiBinder = GWT
			.create(ClientsUiUiBinder.class);

	interface ClientsUiUiBinder extends UiBinder<Widget, ClientsUi> {
	}

	public ClientsUi() {
		initWidget(uiBinder.createAndBindUi(this));
		String[] headers = {"Client Name","Type",""};
		this.clientTable.setHeaders(headers);
		this.setChannels(CLIENTSUI);
		bind();
	}

	@UiField Button button;
	@UiField DynamicTableWidget clientTable;

	public ClientsUi(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		History.newItem("massexposure/clients/new");
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
		String command = this.getCommand(message);
		if(ComposeEvent.REPLACE.equalsIgnoreCase(command)){
			clearTable();
			updateTableRecords(message);
		}
	}

	private void clearTable() {
		this.clientTable.clear();
	}

	private void updateTableRecords(JavaScriptObject message) {
		JsArray<ClientJO> records = this.getRecords(message);
		for(int i = 0; i < records.length();i++){
			ClientDTO client = records.get(i).toClientDTO();
			DynamicTableRowWidget row = createRow(client);
			clientTable.appendRow(row);
		}
	}

	private DynamicTableRowWidget createRow(ClientDTO client) {
		Widget[] row1 = new Widget[2];
		row1[0] = new Label(client.getName());
		Button b = new Button("View");
		b.setStyleName("btn");
		b.getElement().setAttribute("onclick", "window.location = '#massexposure/clients/"+client.getClientId()+"'");
		row1[1] = b;
		DynamicTableRowWidget row = new DynamicTableRowWidget();
		row.setContent(row1);
		return row;
	}
	
	private native JsArray<ClientJO> getRecords(JavaScriptObject message)/*-{
		return message.records;
	}-*/;

	
	private native String getCommand(JavaScriptObject message) /*-{
		try{
			return message.command;
		}catch(Exception){
			return "";
		}
	}-*/;

	private native int getRecordCount(JavaScriptObject message) /*-{
		try{
			return message.records.length;
		}catch(Exception){
			return 0;
		}
	}-*/;

	@Override
	public void handleEvent(String command, Widget[] messages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleObjectEvent(Object message) {
		if(message instanceof ClientDTO[]){
			this.clearTable();
			populateTable((ClientDTO[])message);
		}
		
	}

	private void populateTable(ClientDTO[] message) {
		for(int i = 0;i < message.length;i++){
			this.clientTable.appendRow(this.createRow(message[i]));
		}
	}

}
