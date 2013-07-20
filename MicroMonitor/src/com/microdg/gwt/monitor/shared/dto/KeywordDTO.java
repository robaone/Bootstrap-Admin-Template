package com.microdg.gwt.monitor.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class KeywordDTO implements IsSerializable {
	private String name;
	private int siteId;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public void setId(int i) {
		this.id = i;
	}
	public int getId(){
		return this.id;
	}
}
