package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnlineStarWork {
	
    private Long id;

    @JsonProperty("os_id")
    private Long osId;

    @JsonProperty("image_id")
    private Long imageId;

    @JsonProperty("type_id")
    private Integer typeId;

    private String explain;
    
    @JsonProperty("image_name")
    private String imageName;

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

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
    
}