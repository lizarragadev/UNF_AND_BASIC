package com.miramicodigo.basicexam;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class Matter {
    private String name;
    private String initials;
    private String type;

    public Matter() {

    }

    public Matter(String name, String initials, String type) {
        this.name = name;
        this.initials = initials;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
