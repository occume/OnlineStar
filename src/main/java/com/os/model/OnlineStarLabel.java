package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnlineStarLabel {
	
    private Long id;

    @JsonProperty("os_id")
    private Long osId;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OnlineStarLabel [name=" + name + "]";
	}
    
}