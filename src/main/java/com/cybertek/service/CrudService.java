package com.cybertek.service;

import java.util.List;

public interface CrudService<T, ID> { //generic
    List<T> findAll();
    T findById(ID userId);
    T save(T object); //obj can be RoleDTO or UserDTO ...
    void delete(T object);
    void deleteById(ID userId);
}
