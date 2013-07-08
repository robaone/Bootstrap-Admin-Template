package com.microdg.gwt.monitor.client;

import com.microdg.gwt.monitor.client.view.login.LoginUi;
import com.microdg.gwt.monitor.client.view.main.MainLayoutUi;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MicroMonitor implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * This is the entry point method.
	 */
	private MainLayoutUi layout;
	private DockLayoutPanel mainLayout;
	private LoginUi login;
	public void onModuleLoad() {
		
		mainLayout = buildMainLayout();
		login = buildLoginLayout();
		RootLayoutPanel.get().add(login);
		
		/*
		Document.get().getBody().appendChild(layout.getElement());
		*/
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
}
