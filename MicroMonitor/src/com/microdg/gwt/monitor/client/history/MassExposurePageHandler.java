package com.microdg.gwt.monitor.client.history;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.microdg.gwt.monitor.client.MicroMonitor;
import com.microdg.gwt.monitor.client.callback.CreateNewSiteCallback;
import com.microdg.gwt.monitor.client.handlers.NewKeywordSubmitHandler;
import com.microdg.gwt.monitor.client.handlers.NewServiceAreaSubmitHandler;
import com.microdg.gwt.monitor.client.handlers.NewSiteSubmitHandler;
import com.microdg.gwt.monitor.shared.ArrayTools;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;

public class MassExposurePageHandler implements ApplicationHistoryHandler {

	@Override
	public void handle(String[] parsed) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-page-name","Mass Exposure"));
		EventBus.handleEvent("root", ComposeEvent.REPLACE, MicroMonitor.getMainLayoutUi());
		String subpage = "";
		if(parsed.length > 1){
			subpage = parsed[1];
		}
		ApplicationHistoryHandler handler;
		try {
			handler = ApplicationHistoryHandlerFactory.newInstance(ArrayTools.toString(parsed, "/"));
			handler.handle(ArrayTools.subset(parsed,1));
		} catch (Exception e) {
			ErrorPageHandler error = new ErrorPageHandler();
			error.handle(e);
		}
		
		/*
			if(parsed[1].equalsIgnoreCase("new")){
				renderNewSiteForm();
			}else if(parsed[1].equalsIgnoreCase("view")){
				if(parsed.length == 3){
					renderSiteView(Integer.parseInt(parsed[2]));
				}else if(parsed.length == 5){
					if(parsed[3].equalsIgnoreCase("keyword")){
						renderNewKeywordForm(Integer.parseInt(parsed[2]));
					}else if(parsed[3].equalsIgnoreCase("servicearea")){
						renderNewServiceAreaForm(Integer.parseInt(parsed[2]));
					}
				}
			}
		}
		 */
	}

	private void renderNewServiceAreaForm(int parseInt) {
		FlowPanel panel = new FlowPanel();
		Label title = new Label("New Service Area");
		panel.add(title);
		final FormPanel form = new FormPanel();
		form.setStyleName("form");
		panel.add(form);
		InlineLabel name = new InlineLabel("Service Area");
		FlowPanel form_contents = new FlowPanel();
		form_contents.add(name);
		form.add(form_contents);
		TextBox name_txt = new TextBox();
		form_contents.add(name_txt);
		Button submit = new Button("Submit");
		submit.setStyleName("btn btn-primary");
		form_contents.add(submit);
		form.addSubmitHandler(new NewServiceAreaSubmitHandler(parseInt,name_txt));
		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				form.submit();
			}
			
		});
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, panel);
	}

	private void renderNewKeywordForm(int parseInt) {
		FlowPanel panel = new FlowPanel();
		Label title = new Label("New Keyword");
		panel.add(title);
		final FormPanel form = new FormPanel();
		form.setStyleName("form");
		panel.add(form);
		InlineLabel name = new InlineLabel("Keyword");
		FlowPanel form_contents = new FlowPanel();
		form_contents.add(name);
		form.add(form_contents);
		TextBox name_txt = new TextBox();
		form_contents.add(name_txt);
		Button submit = new Button("Submit");
		submit.setStyleName("btn btn-primary");
		form_contents.add(submit);
		form.addSubmitHandler(new NewKeywordSubmitHandler(parseInt,name_txt));
		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				form.submit();
			}
			
		});
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, panel);
	}

	private void renderSiteView(int id) {
		MicroMonitor.dataService.getSiteInfo(id,new CreateNewSiteCallback());
		
	}

	private void renderNewSiteForm() {
		FlowPanel panel = new FlowPanel();
		Label title = new Label("New Site");
		panel.add(title);
		final FormPanel form = new FormPanel();
		form.setStyleName("form");
		panel.add(form);
		InlineLabel name = new InlineLabel("Site Name");
		FlowPanel form_contents = new FlowPanel();
		form_contents.add(name);
		form.add(form_contents);
		TextBox name_txt = new TextBox();
		form_contents.add(name_txt);
		Button submit = new Button("Submit");
		submit.setStyleName("btn btn-primary");
		form_contents.add(submit);
		form.addSubmitHandler(new NewSiteSubmitHandler(name_txt));
		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				form.submit();
			}
			
		});
		EventBus.handleEvent("root-content", ComposeEvent.REPLACE, panel);
	}

}
