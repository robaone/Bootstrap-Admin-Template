package com.microdg.gwt.monitor.client.control;

import java.awt.Dialog;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * <pre>   Copyright 2013 Ansel Robateau
         http://www.robaone.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.</pre>
 * @author Ansel
 *
 */
public class ApplicationGeneralErrorHandler implements ApplicationEventHandler<String> {

	@Override
	public void handle(String message) {
		final DialogBox dialog = new DialogBox();
		dialog.setText("Application Error");
		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("100%");
		vp.add(new Label(message));
		Button b = new Button("OK");
		vp.add(b);
		b.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				dialog.hide();
			}
			
		});
		dialog.setGlassEnabled(true);
		dialog.getElement().setAttribute("style", "background-color:white");
		dialog.setAnimationEnabled(true);
		dialog.setWidget(vp);
		dialog.center();
	}

	@Override
	public void handleJs(JavaScriptObject message) {
		// TODO Auto-generated method stub

	}

}
