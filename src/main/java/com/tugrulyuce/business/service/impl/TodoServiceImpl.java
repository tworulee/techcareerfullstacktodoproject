package com.tugrulyuce.business.service.impl;

import com.tugrulyuce.bean.ModelMapperBean;
import com.tugrulyuce.business.dto.TodoDto;
import com.tugrulyuce.business.service.ITodoGenericsService;
import com.tugrulyuce.business.service.impl.data.entity.TodoEntity;
import com.tugrulyuce.business.service.impl.data.repository.ITodoRepository;
import com.tugrulyuce.exception.BadRequestException;
import com.tugrulyuce.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor // Injection
@Log4j2

// SERVICE


@Service // Asıl iş Yükünü yapan yer
public class TodoServiceImpl implements ITodoGenericsService<TodoDto, TodoEntity> {

    private final ModelMapperBean modelMapperBean;
    private final ITodoRepository iTodoRepository;

    // ### Model Mapper ###############################
    @Override
    public TodoDto EntityToDto(TodoEntity todoEntity) {
        return modelMapperBean.modelMapperMethod().map(todoEntity, TodoDto.class);
    }

    @Override
    public TodoEntity DtoToEntity(TodoDto todoDto) {
        return modelMapperBean.modelMapperMethod().map(todoDto, TodoEntity.class);
    }

    // ### CRUD ###############################
    // CREATE
    @Transactional // Create, Delete, Update
    @Override
    public TodoDto todoServiceCreate(TodoDto todoDto) {
        if (todoDto != null) {
            TodoEntity todoEntityModel = DtoToEntity(todoDto);
            TodoEntity todoEntity = iTodoRepository.save(todoEntityModel);
            todoDto.setId(todoEntity.getId());
            todoDto.setSystemDate(todoDto.getSystemDate());
        } else if (todoDto == null)
            throw new BadRequestException("TodoDto is empty");
        return todoDto;
    }

    // LIST
    @Override
    public List<TodoDto> todoServiceList() {
        Iterable<TodoEntity> todoEntityIterable = iTodoRepository.findAll();
        List<TodoDto> list = new ArrayList<>();
        for (TodoEntity entity : todoEntityIterable) {
            TodoDto todoDto = EntityToDto(entity);
            list.add(todoDto);
        }
        return list;
    }

    // FIND
    @Override
    public TodoDto todoServiceFindById(Long id) {
        TodoEntity todoEntity = null;
        if (id != null) {
            todoEntity = iTodoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " cant found"));
        } else if (id == null)
            throw new BadRequestException(id + "is null"); // 400
        return EntityToDto(todoEntity);
    }

    // DELETE
    @Transactional // Create, Delete, Update
    @Override
    public TodoDto todoServiceDeleteById(Long id) {
        TodoDto todoDtoDeleteFind = todoServiceFindById(id);
        TodoEntity todoEntity = DtoToEntity(todoDtoDeleteFind);
        iTodoRepository.delete(todoEntity);
        return todoDtoDeleteFind;
    }

    // Update
    // CommandLineRunner

    // UPDATE
    @Transactional // Create, Delete, Update
    @Override
    public TodoDto todoServiceUpdateById(Long id, TodoDto todoDto) {
        TodoEntity todoEntity = DtoToEntity(todoServiceFindById(id));
        if (todoEntity != null) {
            todoEntity.setId(id);
            todoEntity.setTodo(todoDto.getTodo());
            todoEntity.setCompleted(todoDto.isCompleted());
            todoEntity.setSystemDate(new Date());
            iTodoRepository.save(todoEntity);

        }
        return EntityToDto(todoEntity);
    }



    // ### PROFILE ########################################################################
    // ÇOKLU VERİ SİL

    @Override
    public String allDeleteService() {
        iTodoRepository.deleteAll();
        return "DELETED ";
    }
    @Override
    public List<TodoDto> speedDataService() {
        return null;
    }

    // APP INFO
    @Override
    public String appInformationService(HttpServletRequest request, HttpServletResponse response) {
        // URL URI
        // relative Path, absolute Path
        String URI = request.getRequestURI();
        String LOCALHOST = request.getLocalAddr();
        String SESSION = request.getSession().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URI).append(" ").append(LOCALHOST).append(" ").append(SESSION);
        return stringBuilder.toString();
    }
} //end class
