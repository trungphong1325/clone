package com.treeforcom.clone.data;

import com.google.gson.annotations.SerializedName;

public class ResponseError {
    @SerializedName("status")
    private boolean status;
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("message")
    private String message;

    public ResponseError(boolean status, int status_code, String message) {
        this.status = status;
        this.status_code = status_code;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int isStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
