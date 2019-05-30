package com.treeforcom.clone.Mapper;

public interface IMapper<V, D> {
    V mapToModel(D type);
}
