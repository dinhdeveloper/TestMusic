package com.main.exception;

public class RecordNotFoundException  extends RuntimeException {
    private String exceptionDetail;
    private Object fieldValue;

    public RecordNotFoundException( String exceptionDetail, Integer fieldValue) {
        super(exceptionDetail+" - "+fieldValue);
        this.exceptionDetail = exceptionDetail;
        this.fieldValue = fieldValue;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
