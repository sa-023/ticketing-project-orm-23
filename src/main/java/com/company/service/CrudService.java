package com.company.service;

import java.util.List;

public interface CrudService <T,ID> {

    // CRUD : Create, Read, Update, Delete.
    T save(T object);
    List<T> findAll();
    T findById(ID id);
    void deleteById(ID id);
    void  update(T object);


}
