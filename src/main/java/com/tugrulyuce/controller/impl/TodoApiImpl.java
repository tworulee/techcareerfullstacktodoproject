package com.tugrulyuce.controller.impl;

import com.tugrulyuce.business.dto.TodoDto;
import com.tugrulyuce.business.service.ITodoGenericsService;
import com.tugrulyuce.controller.ITodoGenericsApiController;
import com.tugrulyuce.error.ApiResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor //Injection
@Log4j2

// API
@RestController
//@CrossOrigin(origins = FrontEndURL.FRONTEND_URL, allowedHeaders = "*") // CORS localhost
@CrossOrigin(origins = "*", allowedHeaders = "*") // CORS for docker-compose
@RequestMapping("/todos")
public class TodoApiImpl implements ITodoGenericsApiController<TodoDto> {

    // INJECTION
    private final ITodoGenericsService iTodoGenericsService;

    //ERROR
    private ApiResult apiResult;

    // ### ROOT ###############################
    // localhost:2222
    // localhost:2222/index
    @Override
    @GetMapping({"/", "/index"})
    public ResponseEntity<String> getRoot() {
        return ResponseEntity.ok("index");
    }

    // SPEED
    // localhost:2222/todos/speed/data
    @GetMapping("/speed/data")
    @Override
    public ResponseEntity<List<TodoDto>> speedDataService() {
        return ResponseEntity.ok(iTodoGenericsService.speedDataService());
    }

    // localhost:2222/todos/api/delete
    @GetMapping("/all/delete")
    @Override
    public ResponseEntity<String> allDeleteService() {
        return ResponseEntity.ok(iTodoGenericsService.allDeleteService());
    }

    // localhost:2222/todos/api/information
    @GetMapping("/app/information")
    @Override
    public ResponseEntity<String> appInformationService(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(iTodoGenericsService.appInformationService(request,response));
    }

    // ### CRUD ###############################
    // CREATE
    // localhost:2222/todos/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> todoServiceCreate(@Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(iTodoGenericsService.todoServiceCreate(todoDto));
    }

    // LIST
    // localhost:2222/todos/list
    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<TodoDto>> todoServiceList() {
        return ResponseEntity.ok(iTodoGenericsService.todoServiceList());
    }

    // FIND
    // localhost:2222/todos/find
    // localhost:2222/todos/find/0
    // localhost:2222/todos/find/1
    @Override
    @GetMapping({"/find", "/find/{id}"})
    public ResponseEntity<?> todoServiceFindById(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            throw new NullPointerException(id + " is null");
        }
        if (id == 0) {
            //(int status, String error, String message, String path)
            apiResult = new ApiResult(400, "bad Request", " Kötü İstek", "/todo/api/v1/find/0");
            return ResponseEntity.ok(apiResult);
        }
        return ResponseEntity.ok(iTodoGenericsService.todoServiceFindById(id));
    }

    // DELETE
    // localhost:2222/todos/delete/1
    @Override
    @DeleteMapping({"/delete", "/delete/{id}"})
    public ResponseEntity<?> todoServiceDeleteById(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iTodoGenericsService.todoServiceDeleteById(id));
    }

    // UPDATE
    // localhost:2222/todos/update/1
    @Override
    @PutMapping({"/update", "/update/{id}"})
    public ResponseEntity<?> todoServiceUpdateById(
            @PathVariable(name = "id", required = false) Long id,
            @Valid @RequestBody TodoDto todoDto) {
        todoDto.setId(id);
        return ResponseEntity.ok(iTodoGenericsService.todoServiceUpdateById(id, todoDto));
    }

}
