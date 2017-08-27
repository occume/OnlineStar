package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BannerImage {
	
    private Long id;

    @JsonProperty("image_name")
    private String imageName;

    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}