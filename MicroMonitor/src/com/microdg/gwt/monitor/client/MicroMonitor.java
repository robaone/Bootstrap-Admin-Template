package com.microdg.gwt.monitor.client;

import com.microdg.gwt.monitor.client.view.main.MainLayoutUi;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;

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
	public void onModuleLoad() {
		
		MainLayoutUi layout = new MainLayoutUi();
		Document.get().getBody().appendChild(layout.getElement());
	}
}
