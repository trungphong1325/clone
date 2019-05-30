package com.treeforcom.clone.data.remote.response.login;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("status")
    private boolean status;
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("message")
    private String message;
    @Nullable
    @SerializedName("result")
    private User user;

    public UserResponse() {
    }

    public UserResponse(boolean status, int status_code, String message, @Nullable User user) {
        this.status = status;
        this.status_code = status_code;
        this.message = message;
        this.user = user;
    }

    @Nullable
    public User getUser() {
        return user;
    }

    public void setUser(@Nullable User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatus_code() {
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
