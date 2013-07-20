package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.widget.DynamicTableRowWidget;
import com.robaone.gwt.eventbus.client.widget.DynamicTableWidget;

public class ServiceAreaTable extends EventDrivenComposite {
	DynamicTableWidget table;
	public ServiceAreaTable(){
		bind();
		table = new DynamicTableWidget();
		table.setStyleName("table");
		this.initWidget(table);
		String[] header = {"City","State","Zip"};
		table.setHeaders(header);
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
		try{
			table.setRows((DynamicTableRowWidget[]) messages);
		}catch(Exception e){}
	}

	@Override
	public void handleObjectEvent(Object message) {
		ServiceAreaDTO[] area = (ServiceAreaDTO[])message;
		DynamicTableRowWidget[] rows = new DynamicTableRowWidget[area.length];
		for(int i = 0; i < area.length;i++){
			DynamicTableRowWidget row = new DynamicTableRowWidget();
			String[] cells = {area[i].getCity(),area[i].getState(),area[i].getZip()};
			row.setContent(cells);
			rows[i] = row;
		}
		this.table.setRows(rows);
	}

}
