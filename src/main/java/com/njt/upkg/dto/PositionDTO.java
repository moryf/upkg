package com.njt.upkg.dto;

public class PositionDTO {
    Long id;
    Long projectId;
    String name;
    boolean redyToMount;
    boolean mounted;

    public PositionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public boolean isRedyToMount() {
        return redyToMount;
    }

    public void setRedyToMount(boolean redyToMount) {
        this.redyToMount = redyToMount;
    }

    public boolean isMounted() {
        return mounted;
    }

    public void setMounted(boolean mounted) {
        this.mounted = mounted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
