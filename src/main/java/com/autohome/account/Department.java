package com.autohome.account;

/**
 * Created by sdhjl2000 on 16/11/12.
 */
public class Department implements java.io.Serializable {
    public String getDepartName() {
        return departName;
    }

    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Department(String departName, Integer level) {
        this.level = level;
        this.departName = departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    private String departName;
}
