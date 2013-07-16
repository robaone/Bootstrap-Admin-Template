package com.microdg.gwt.monitor.client;

import com.microdg.gwt.monitor.client.control.AppController;
import com.microdg.gwt.monitor.client.history.ApplicationHistory;
import com.microdg.gwt.monitor.client.rpc.DataService;
import com.microdg.gwt.monitor.client.rpc.DataServiceAsync;
import com.microdg.gwt.monitor.client.view.login.LoginUi;
import com.microdg.gwt.monitor.client.view.main.MainLayoutUi;
import com.microdg.gwt.monitor.shared.dto.AppSessionDataDTO;
import com.robaone.gwt.eventbus.client.ComposeEvent;
import com.robaone.gwt.eventbus.client.EventBus;
import com.robaone.gwt.eventbus.client.EventDrivenController;
import com.robaone.gwt.eventbus.client.ObjectChannelEvent;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MicroMonitor extends EventDrivenController implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	public static final DataServiceAsync dataService = GWT.create(DataService.class);

	/**
	 * This is the entry point method.
	 */
	private static MainLayoutUi layout;
	private static DockLayoutPanel mainLayout;
	private static LoginUi login;
	@SuppressWarnings("unused")
	private AppController controller;
	public void onModuleLoad() {
		this.setChannels("root");
		bind();
		
		mainLayout = buildMainLayout();
		login = buildLoginLayout();
		initAppController();
		EventBus.handleObjectEvent(new ObjectChannelEvent("initialize","App"));
		
		
	}
	public static Widget getMainLayout(){
		return mainLayout;
	}
	public static MainLayoutUi getMainLayoutUi(){
		return layout;
	}
	private void initAppController() {
		controller = new AppController();
		ApplicationHistory history = new ApplicationHistory();
		History.addValueChangeHandler(history);
		history.handleObjectEvent(History.getToken());
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
		appPanel.addSouth(new HTML("<div id=\"footer\"><p>Admin Dashboard</p></div>"), 3);
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.addStyleName("wrap");
		scrollPanel.add(layout);
		appPanel.add(scrollPanel);
		return appPanel;
	}
	@Override
	public void handleEvent(String command, Widget message) {
		if(ComposeEvent.REPLACE.equals(command)){
			if(RootLayoutPanel.get().getWidgetCount() == 0 || !RootLayoutPanel.get().getWidget(0).equals(message)){
				RootLayoutPanel.get().clear();
				RootLayoutPanel.get().add(message);
			}
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
	public void handleObjectEvent(Object message) {
		// TODO Auto-generated method stub
		
	}
	public static Widget getLoginPage() {
		return login;
	}
	public static void setAppSessionData(AppSessionDataDTO result) {
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-profile",result.getProfile()));
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-brand",result.getBrand()));
	}

}
