package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.shared.dto.KeywordDTO;

public interface KeywordHandlerTemplate {

	KeywordDTO saveSiteKeyword(KeywordDTO message);

	KeywordDTO[] getSiteKeywords(int id);

}
