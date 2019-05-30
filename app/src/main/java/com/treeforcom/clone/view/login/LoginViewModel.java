package com.treeforcom.clone.view.login;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.treeforcom.clone.data.ResourceModel;
import com.treeforcom.clone.data.remote.request.login.LoginParam;
import com.treeforcom.clone.data.remote.response.login.UserResponse;
import com.treeforcom.clone.domain.login.LoginRepository;
import com.treeforcom.clone.remote.login.LoginService;
import javax.inject.Inject;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository;
    @Nullable
    private LiveData<ResourceModel<UserResponse>> userResponseLiveData = new MutableLiveData<>();

    @Inject
    LoginViewModel(LoginService loginService) {
        loginRepository = new LoginRepository(loginService);
    }

    LiveData<ResourceModel<UserResponse>> userResponseLiveData() {
        return userResponseLiveData;
    }

    void authenticate(LoginParam loginParam) {
        userResponseLiveData = loginRepository.authenticate(loginParam.getUsername(), loginParam.getPassword());
    }
}
