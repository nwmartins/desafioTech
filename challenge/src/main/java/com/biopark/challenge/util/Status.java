package com.biopark.challenge.util;

import java.io.Serializable;

public enum Status implements Serializable {

    OPEN("aberto"),
    CLOSED("fechado");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
