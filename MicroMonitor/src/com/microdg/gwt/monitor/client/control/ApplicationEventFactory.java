package com.microdg.gwt.monitor.client.control;

public class ApplicationEventFactory {

	public static final String APP_ERROR = "app-error";

	public static ApplicationEventHandler newInstance(String channel) {
		if("initialize".equals(channel)){
			return new ApplicationInitializeHandler();
		}else if(APP_ERROR.equals(channel)){
			return new ApplicationGeneralErrorHandler();
		}else if("login".equals(channel)){
			return new ApplicationLoginHandler();
		}else if("login-result".equals(channel)){
			return new ApplicationLoginResultHandler();
		}else if("logout".equals(channel)){
			return new ApplicationLogoutHandler();
		}else if("recover-password".equals(channel)){
			return new ApplicationRecoverPasswordHandler();
		}else if("recover-password-success".equals(channel)){
			return new ApplicationRecoverPasswordSuccessHandler();
		}else if("register-user".equals(channel)){
			return new ApplicationRegisterUserHandler();
		}else if("set-brand".equals(channel)){
			return new ApplicationBrandHandler();
		}else if("set-page-name".equals(channel)){
			return new ApplicationPageNameHandler();
		}else if("set-profile".equals(channel)){
			return new ApplicationProfileHandler();
		}else if("site:create-new".equalsIgnoreCase(channel)){
			return new ApplicationSaveNewSiteHandler();
		}else if("site:view".equalsIgnoreCase(channel)){
			return new ApplicationViewSiteHandler();
		}else if("site:save-keyword".equalsIgnoreCase(channel)){
			return new ApplicationSaveKeywordHandler();
		}else if("site:load-keywords".equalsIgnoreCase(channel)){
			return new ApplicationKeywordViewHandler();
		}else if("site:load-serviceareas".equalsIgnoreCase(channel)){
			return new ApplicationServiceAreaViewHandler();
		}else if("site:save-servicearea".equalsIgnoreCase(channel)){
			return new ApplicationSaveServiceAreaHandler();
		}
		return null;
	}

}
