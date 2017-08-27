package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobImage {
    private Long id;

    @JsonProperty("job_id")
    private Long jobId;

    @JsonProperty("image_id")
    private Long imageId;

    @JsonProperty("image_name")
    private String imageName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }
}