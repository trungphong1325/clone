package com.treeforcom.clone.data;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NetworkBoundSource<ResultType> {
//    private Observable<ResourceModel<ResultType>> result;
    private final MediatorLiveData<ResourceModel<ResultType>> result = new MediatorLiveData<>();


    @MainThread
    protected NetworkBoundSource() {
        result.postValue(ResourceModel.loading());
//        result = createCall()
//                .subscribeOn(Schedulers.io())
//                .doOnNext(ResourceModel::success)
//                .doOnError(t -> ResourceModel.error(t.getMessage()))
//                .onErrorResumeNext(t -> {
//                    ResourceModel.error("");
//                })
//                .observeOn(AndroidSchedulers.mainThread());

    }


//    public Observable<ResourceModel<ResultType>> getAsObservable() {
////        return result;
////    }
////    @NonNull
////    @MainThread
////    protected abstract Observable<ResourceModel<ResultType>> createCall();
////
////    @NonNull
////    @MainThread
////    protected abstract Observable<ResourceModel<ResponseError>> createCallFailed();

    @MainThread
    private void setValue( ResourceModel<ResultType> newValue) {
        result.setValue(newValue);
    }


    @NonNull
    @MainThread
    protected abstract LiveData<ResultType> createCall();

    public final LiveData<ResourceModel<ResultType>> getAsLiveData() {
        return result;
    }
}
