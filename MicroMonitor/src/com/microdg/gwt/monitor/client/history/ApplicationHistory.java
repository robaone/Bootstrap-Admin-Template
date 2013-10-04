package com.microdg.gwt.monitor.client.history;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.robaone.gwt.eventbus.client.EventDrivenController;

public class ApplicationHistory extends EventDrivenController implements
ValueChangeHandler<String> {
	public ApplicationHistory(){
		bind();
	}
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		this.handleObjectEvent(event.getValue());
	}

	@Override
	public void handleEvent(String command, Widget message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEvent(String command, Widget[] messages) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEvent(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleObjectEvent(Object message) {
		System.out.println("ApplicationHistory: "+message);
		if(message != null){
			String[] parsed = message.toString().split("/");
			try{
				if("".equals(parsed[0]) || "home".equalsIgnoreCase(parsed[0])){
					parsed[0] = "home";
				}
				handle(parsed);
			}catch(Exception e){
				if("getsessiondata".equals(e.getMessage())){
					MicroMonitor.dataService.getSessionData(new AsyncCallback<AppSessionDataDTO>(){

						@Override
						public void onFailure(Throwable caught) {
							String[] page = {"error404"};
							try {
								handle(page);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						@Override
						public void onSuccess(AppSessionDataDTO result) {
							MicroMonitor.setAppSessionData(result);
							ApplicationHistory.this.handleObjectEvent(History.getToken());
						}
						
					});
				}else{
					String[] page = {"error404"};
					try {
						handle(page);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	private void handle(String[] parsed) throws Exception {
		ApplicationHistoryHandler home = ApplicationHistoryHandlerFactory.newInstance(parsed[0]);
		home.handle(parsed);
	}
	

}
