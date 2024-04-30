package com.example.SpringTestJava.Enums;

public enum AccountTypeEnum {

    Y("Y"),
    S("Savings"),
    C("Checking"),
    ;

    private String dscp;

    private AccountTypeEnum (String dscp){
        this.dscp=dscp;
    }

    public String getDscp() {
        return dscp;
    }
}
