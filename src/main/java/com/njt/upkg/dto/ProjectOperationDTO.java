package com.njt.upkg.dto;

import com.njt.upkg.domain.OperationType;

import java.util.Date;

public class ProjectOperationDTO {
    Long id;
    Long prrojectID;
    Long positionID;
    Long workerID;
    OperationType type;
    Date start;
    Date ended;
    boolean active;

    public ProjectOperationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrrojectID() {
        return prrojectID;
    }

    public void setPrrojectID(Long prrojectID) {
        this.prrojectID = prrojectID;
    }

    public Long getPositionID() {
        return positionID;
    }

    public void setPositionID(Long positionID) {
        this.positionID = positionID;
    }

    public Long getWorkerID() {
        return workerID;
    }

    public void setWorkerID(Long workerID) {
        this.workerID = workerID;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnded() {
        return ended;
    }

    public void setEnded(Date ended) {
        this.ended = ended;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
