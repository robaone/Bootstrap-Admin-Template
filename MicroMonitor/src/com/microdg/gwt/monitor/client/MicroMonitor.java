package com.microdg.gwt.monitor.client;

import com.microdg.gwt.monitor.client.control.AppController;
import com.microdg.gwt.monitor.client.history.ApplicationHistory;
import com.microdg.gwt.monitor.client.rpc.DataService;
import com.microdg.gwt.monitor.client.rpc.DataServiceAsync;
import com.microdg.gwt.monitor.client.view.ClientCreationFormUi;
import com.microdg.gwt.monitor.client.view.ClientEmployeeEditFormUi;
import com.microdg.gwt.monitor.client.view.ClientEmployeeViewUi;
import com.microdg.gwt.monitor.client.view.ClientViewUi;
import com.microdg.gwt.monitor.client.view.ClientsUi;
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
	private static ScrollPanel scrollPanel = new ScrollPanel();
	private static LoginUi login;
	private static ClientsUi clientList;
	private static ClientCreationFormUi clientCreationForm;
	private static ClientEmployeeViewUi clientEmployeeView;
	private static ClientEmployeeEditFormUi clientEmployeeEditForm;
	private static ClientViewUi clientView;
	private static AppSessionDataDTO sessionData;
	@SuppressWarnings("unused")
	private AppController controller;
	public void onModuleLoad() {
		this.setChannels("root");
		bind();
		scrollPanel.setWidth("100%");
		scrollPanel.setHeight("100%");
		RootLayoutPanel.get().add(scrollPanel);
		mainLayout = buildMainLayout();
		login = buildLoginLayout();
		MicroMonitor.setClientList(new ClientsUi());
		MicroMonitor.setClientCreationForm(new ClientCreationFormUi());
		MicroMonitor.setClientView(new ClientViewUi());
		MicroMonitor.setClientEmployeeView(new ClientEmployeeViewUi());
		MicroMonitor.setClientEmployeeEditForm(new ClientEmployeeEditFormUi());
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
		layout.setChannels("root-content");
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
			if(scrollPanel.getWidget() == null || !scrollPanel.getWidget().equals(message)){
				scrollPanel.setWidget(message);
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
		sessionData = result;
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-profile",result.getProfile()));
		EventBus.handleObjectEvent(new ObjectChannelEvent("set-brand",result.getBrand()));
	}
	public static AppSessionDataDTO getAppSessionData(){
		return sessionData;
	}
	public static ClientsUi getClientList() {
		return clientList;
	}
	public static void setClientList(ClientsUi clientList) {
		MicroMonitor.clientList = clientList;
	}
	public static ClientCreationFormUi getClientCreationForm() {
		return clientCreationForm;
	}
	public static void setClientCreationForm(ClientCreationFormUi clientCreationForm) {
		MicroMonitor.clientCreationForm = clientCreationForm;
	}
	public static ClientViewUi getClientView() {
		return clientView;
	}
	public static void setClientView(ClientViewUi clientView) {
		MicroMonitor.clientView = clientView;
	}
	public static ClientEmployeeViewUi getClientEmployeeView() {
		return clientEmployeeView;
	}
	public static void setClientEmployeeView(ClientEmployeeViewUi clientEmployeeView) {
		MicroMonitor.clientEmployeeView = clientEmployeeView;
	}
	public static ClientEmployeeEditFormUi getClientEmployeeEditForm() {
		return clientEmployeeEditForm;
	}
	public static void setClientEmployeeEditForm(ClientEmployeeEditFormUi clientEmployeeEditForm) {
		MicroMonitor.clientEmployeeEditForm = clientEmployeeEditForm;
	}
}
