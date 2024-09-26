package com.erp.maisPraTi.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    FEMALE("F"),
    MALE("M"),
    NOTE_INFORMED("N");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @JsonValue
    public String getGender(){
        return this.gender;
    }
}
