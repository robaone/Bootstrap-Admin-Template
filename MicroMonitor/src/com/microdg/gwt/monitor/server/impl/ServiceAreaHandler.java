package com.microdg.gwt.monitor.server.impl;

import java.util.ArrayList;

import com.microdg.gwt.monitor.server.ServiceAreaHandlerTemplate;
import com.microdg.gwt.monitor.shared.dto.ServiceAreaDTO;

public class ServiceAreaHandler implements ServiceAreaHandlerTemplate {

	@Override
	public ServiceAreaDTO[] getSiteServiceAreas(int id) {
		ArrayList<ServiceAreaDTO> list = new ArrayList<ServiceAreaDTO>();
		for(int i = 0; i < 4;i++){
			ServiceAreaDTO area = new ServiceAreaDTO();
			area.setCity("City "+i);
			area.setState("State " + i);
			area.setZip("Zip "+i);
			list.add(area);
		}
		return list.toArray(new ServiceAreaDTO[0]);
	}

}
