package com.microdg.gwt.monitor.server.impl;

import java.util.ArrayList;

import com.microdg.gwt.monitor.server.KeywordHandlerTemplate;
import com.microdg.gwt.monitor.server.SessionData;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;

public class KeywordHandler implements KeywordHandlerTemplate {

	public KeywordHandler(SessionData sessionData) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public KeywordDTO saveSiteKeyword(KeywordDTO message) {
		message.setId(1);
		return message;
	}

	@Override
	public KeywordDTO[] getSiteKeywords(int id) {
		ArrayList<KeywordDTO> list = new ArrayList<KeywordDTO>();
		for(int i = 0; i < 2;i++){
			KeywordDTO keyword = new KeywordDTO();
			keyword.setId(i);
			keyword.setName("Keyword "+i);
			keyword.setSiteId(id);
			list.add(keyword);
		}
		return list.toArray(new KeywordDTO[0]);
	}

}
