package com.treeforcom.clone.remote.login;

import androidx.lifecycle.LiveData;

import com.treeforcom.clone.data.remote.response.login.UserResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("login")
    LiveData<UserResponse> authenticate(@Field("email") String email,
                                        @Field("password") String password);
}
