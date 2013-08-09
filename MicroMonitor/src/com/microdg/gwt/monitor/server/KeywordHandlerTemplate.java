package com.microdg.gwt.monitor.server;

import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.KeywordDTO;

public interface KeywordHandlerTemplate {

	KeywordDTO saveSiteKeyword(KeywordDTO message) throws SimpleException, FieldException;

	KeywordDTO[] getSiteKeywords(int id);

}
