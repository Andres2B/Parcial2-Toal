package com.example.calculote;

import java.io.Serializable;

public class ResultData implements Serializable {
    private double result;
    private String operationType;

    public ResultData(double result, String operationType) {
        this.result = result;
        this.operationType = operationType;
    }

    public double getResult() {
        return result;
    }

    public String getOperationType() {
        return operationType;
    }
}
