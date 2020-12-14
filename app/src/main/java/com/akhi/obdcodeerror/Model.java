package com.akhi.obdcodeerror;

public class Model {
    String Code,Description,Possible_Cause;

    public Model() {
    }

    public Model(String code, String description, String possible_Cause) {
        Code = code;
        Description = description;
        Possible_Cause = possible_Cause;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPossible_Cause() {
        return Possible_Cause;
    }

    public void setPossible_Cause(String possible_Cause) {
        Possible_Cause = possible_Cause;
    }
}
