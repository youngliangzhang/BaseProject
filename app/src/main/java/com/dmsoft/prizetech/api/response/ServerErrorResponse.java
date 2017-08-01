package com.dmsoft.prizetech.api.response;


import com.google.gson.annotations.SerializedName;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class ServerErrorResponse {

    @SerializedName("error")
    private String error;
    @SerializedName("code")
    private int code;


    public ServerErrorResponse() {
    }

    public ServerErrorResponse(String message) {
        this.error = message;
    }

    public ServerErrorResponse(Throwable throwable) {

        if (throwable instanceof ConnectException || throwable instanceof SocketTimeoutException){
            error = "Unable to reach to server, please try again";
        }else {
            error = throwable.getMessage();
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String Error) {
        this.error = Error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int Code) {
        this.code = Code;
    }
}
