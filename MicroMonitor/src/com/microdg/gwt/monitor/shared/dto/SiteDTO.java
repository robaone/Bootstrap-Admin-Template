package com.microdg.gwt.monitor.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SiteDTO implements IsSerializable {
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
