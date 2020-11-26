package com.cybertek.utils;

public enum Status {
    OPEN("Opne"), IN_PROGRESS("In Progress"), UAT_TEST("UAT Test"), COMPLETE("Complete");

    private final String value;

    private Status(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
