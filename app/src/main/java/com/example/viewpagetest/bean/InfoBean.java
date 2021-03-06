package com.example.viewpagetest.bean;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class InfoBean implements Serializable {
    private String name;
    private String tabName;

    public InfoBean(String name, String tabName) {
        this.name = name;
        this.tabName = tabName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
}
