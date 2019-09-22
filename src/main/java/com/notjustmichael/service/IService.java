package com.notjustmichael.service;

import java.util.Set;

public interface IService<T, ID> {
    T create(T d);
    T read(ID id);
    T update(T t);
    void delete(ID id);
    Set<T> getAll();
}