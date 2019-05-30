package com.treeforcom.clone.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.treeforcom.clone.data.StatusModel.ERROR;
import static com.treeforcom.clone.data.StatusModel.LOADING;
import static com.treeforcom.clone.data.StatusModel.SUCCESS;

public class ResourceModel<T> {
    @NonNull
    public final StatusModel statusModel;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private ResourceModel(@NonNull StatusModel statusModel, @Nullable T data, @Nullable String message) {
        this.statusModel = statusModel;
        this.data = data;
        this.message = message;
    }

    public static <T> ResourceModel<T> success(@NonNull T data) {
        return new ResourceModel<>(SUCCESS, data, null);
    }

    public static <T> ResourceModel<T> error(String msg) {
        return new ResourceModel<>(ERROR, null, msg);
    }

    static <T> ResourceModel<T> loading() {
        return new ResourceModel<>(LOADING, null, null);
    }

}
