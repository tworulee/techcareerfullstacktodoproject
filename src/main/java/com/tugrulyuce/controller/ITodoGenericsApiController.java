package com.tugrulyuce.controller;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ITodoGenericsApiController<D> extends IAndProfileAppController {

    // Spring MVC (Thymeleaf)
    public ResponseEntity<String>  getRoot();

    // ### CRUD ###############################
    // CREATE
    public ResponseEntity<?> todoServiceCreate(D d);

    // LIST
    public ResponseEntity<List<D>> todoServiceList();

    // FIND
    public ResponseEntity<?> todoServiceFindById(Long id);

    // DELETE
    public  ResponseEntity<?> todoServiceDeleteById(Long id);

    // UPDATE
    public ResponseEntity<?> todoServiceUpdateById(Long id, D d);

}
