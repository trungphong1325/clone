package com.treeforcom.clone.remote.login;

import com.treeforcom.clone.data.remote.response.login.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> authenticate(@Field("email") String email,
                                        @Field("password") String password);
}
