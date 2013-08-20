package com.microdg.gwt.monitor.shared.dto;

public class FieldErrorDTO {
	private String field;
	private String error;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public void setError(String error) {
		this.error = error;
	}
	public FieldErrorDTO(String field,String error){
		this.setField(field);
		this.setError(error);
	}
	public String getError() {
		return this.error;
	}

	public String getFieldName() {
		return this.field;
	}

}
