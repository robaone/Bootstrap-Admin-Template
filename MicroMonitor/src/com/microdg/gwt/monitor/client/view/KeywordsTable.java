package com.microdg.gwt.monitor.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;
import com.robaone.gwt.eventbus.client.EventDrivenComposite;
import com.robaone.gwt.eventbus.client.widget.DynamicTableRowWidget;
import com.robaone.gwt.eventbus.client.widget.DynamicTableWidget;

public class KeywordsTable extends EventDrivenComposite {
	DynamicTableWidget table;
	public KeywordsTable(){
		bind();
		table = new DynamicTableWidget();
		table.setStyleName("table");
		this.initWidget(table);
		String[] header = {"Keywords"};
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
		KeywordDTO[] keywords = (KeywordDTO[])message;
		DynamicTableRowWidget[] rows = new DynamicTableRowWidget[keywords.length];
		for(int i = 0; i < keywords.length;i++){
			DynamicTableRowWidget row = new DynamicTableRowWidget();
			String[] cells = {keywords[i].getName()};
			row.setContent(cells);
			rows[i] = row;
		}
		this.table.setRows(rows);
	}

}
