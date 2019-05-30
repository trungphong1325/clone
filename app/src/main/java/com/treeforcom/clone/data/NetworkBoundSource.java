package com.treeforcom.clone.data;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NetworkBoundSource<ResultType> {
    private final MediatorLiveData<ResourceModel<ResultType>> result = new MediatorLiveData<>();
    @MainThread
    protected NetworkBoundSource() {
        result.setValue(ResourceModel.loading());
        createCall().enqueue(new Callback<ResultType>() {
            @Override
            public void onResponse(@NotNull Call<ResultType> call, @NotNull Response<ResultType> response) {
                if(response.isSuccessful()){
                    if (response.body() != null) {
                        result.setValue(ResourceModel.success(response.body()));
                    }
                }else {
                    result.setValue(ResourceModel.error(response.message()));
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResultType> call, @NotNull Throwable t) {
                result.setValue(ResourceModel.error(t.getMessage()));
            }
        });
    }

    @NonNull
    @MainThread
    protected abstract Call<ResultType> createCall();

    public final MutableLiveData<ResourceModel<ResultType>> getAsLiveData() {
        return result;
    }
}
