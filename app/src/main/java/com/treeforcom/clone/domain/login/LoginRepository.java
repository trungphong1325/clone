package com.treeforcom.clone.domain.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.treeforcom.clone.data.NetworkBoundSource;
import com.treeforcom.clone.data.ResourceModel;
import com.treeforcom.clone.data.remote.response.login.UserResponse;
import com.treeforcom.clone.remote.login.LoginService;
import javax.inject.Singleton;
import io.reactivex.Observable;
import retrofit2.Call;

@Singleton
public class LoginRepository {
    private LoginService loginService;

    public LoginRepository(LoginService loginService) {
        this.loginService = loginService;
    }

    public LiveData<ResourceModel<UserResponse>> authenticate(String email, String password) {
        return new NetworkBoundSource<UserResponse>() {
            @NonNull
            @Override
            protected LiveData<UserResponse> createCall() {
                return loginService.authenticate(email, password);
            }
        }.getAsLiveData();
    }

}
