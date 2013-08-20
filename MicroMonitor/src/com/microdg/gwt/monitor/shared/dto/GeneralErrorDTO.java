package com.microdg.gwt.monitor.shared.dto;

public class GeneralErrorDTO {
	private String error;
	public GeneralErrorDTO(String message) {
		this.setError(message);
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
