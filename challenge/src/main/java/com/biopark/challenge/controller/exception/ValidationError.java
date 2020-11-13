package com.biopark.challenge.controller.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {

    private List<FieldMessage> errors = new ArrayList<>();

    public List<FieldMessage> getError() {
        return errors;
    }

    //Add um erro de cada vez
    public void addError(String fieldName, String msg) {
        errors.add(new FieldMessage(fieldName, msg));
    }

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }
}
