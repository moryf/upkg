package com.njt.upkg.dto;

import com.njt.upkg.domain.ProjectState;

import java.util.Date;

public class ProjectDTO {
    Long buyerID;
    Long createdByID;
    Date deadline;
    Date start;
    String name;
    ProjectState state;

    float value;

    public ProjectDTO() {
    }

    public Long getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Long buyerID) {
        this.buyerID = buyerID;
    }

    public Long getCreatedByID() {
        return createdByID;
    }

    public void setCreatedByID(Long createdByID) {
        this.createdByID = createdByID;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadliDate) {
        this.deadline = deadliDate;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectState getState() {
        return state;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
