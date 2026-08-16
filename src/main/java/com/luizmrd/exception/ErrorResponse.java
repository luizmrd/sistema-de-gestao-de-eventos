package com.luizmrd.exception;

public class ErrorResponse {
    private String message;
    private Integer status;

    public static Builder builder(){
        return  new Builder();
    }
    public ErrorResponse(Builder builder){
        this.message = builder.message;
        this.status = builder.status;
    }
    public static  class Builder{
        private String message;
        private Integer status;

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder status(Integer status){
            this.status = status;
            return this;
        }
        public ErrorResponse build(){
            return new ErrorResponse(this);
        }
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}
