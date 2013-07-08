package com.microdg.gwt.monitor.client;

import com.microdg.gwt.monitor.client.control.AppController;
import com.microdg.gwt.monitor.client.rpc.DataService;
import com.microdg.gwt.monitor.client.rpc.DataServiceAsync;
import com.microdg.gwt.monitor.client.view.login.LoginUi;
import com.microdg.gwt.monitor.client.view.main.MainLayoutUi;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventDrivenController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MicroMonitor  extends EventDrivenController implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	public static final DataServiceAsync dataService = GWT.create(DataService.class);

	/**
	 * This is the entry point method.
	 */
	private MainLayoutUi layout;
	private static DockLayoutPanel mainLayout;
	private static LoginUi login;
	private AppController controller;
	public void onModuleLoad() {
		this.setChannels("main-layout");
		bind();
		
		mainLayout = buildMainLayout();
		login = buildLoginLayout();
		initAppController();
		RootLayoutPanel.get().add(login);
		
		/*
		Document.get().getBody().appendChild(layout.getElement());
		*/
	}
	public static Widget getMainLayout(){
		return mainLayout;
	}
	private void initAppController() {
		controller = new AppController();
	}
	private LoginUi buildLoginLayout() {
		LoginUi login = new LoginUi();
		login.setStyleName("");
		return login;
	}
	private DockLayoutPanel buildMainLayout() {
		layout = new MainLayoutUi();
		layout.addStyleName("wrap");
		layout.setHeight("100%");
		DockLayoutPanel appPanel = new DockLayoutPanel(Unit.EM);
		appPanel.addSouth(new HTML("<div id=\"footer\"><p>2013 &copy; Metis Admin</p></div>"), 3);
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.addStyleName("wrap");
		scrollPanel.add(layout);
		appPanel.add(scrollPanel);
		return appPanel;
	}
	@Override
	public void handleEvent(String command, Widget message) {
		if(ComposeEvent.REPLACE.equals(command)){
			RootLayoutPanel.get().clear();
			RootLayoutPanel.get().add(message);
		}
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
	public void handleNativeEvent(Object message) {
		// TODO Auto-generated method stub
		
	}
	public static Widget getLoginPage() {
		return login;
	}
}
