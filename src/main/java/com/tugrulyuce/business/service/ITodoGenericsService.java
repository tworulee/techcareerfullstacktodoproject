package com.tugrulyuce.business.service;

import java.util.List;

public interface ITodoGenericsService<D, E> extends IProfileApp {

    // ### Model Mapper ###############################
    public D EntityToDto(E e);

    public E DtoToEntity(D d);

    // ### CRUD ###############################
    // CREATE
    public D todoServiceCreate(D d);

    // LIST
    public List<D> todoServiceList();

    // FIND
    public D todoServiceFindById(Long id);

    // DELETE
    public D todoServiceDeleteById(Long id);

    // UPDATE
    public D todoServiceUpdateById(Long id, D d);


}
