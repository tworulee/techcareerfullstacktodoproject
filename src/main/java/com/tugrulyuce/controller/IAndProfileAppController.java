package com.tugrulyuce.controller;

import com.tugrulyuce.business.dto.TodoDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IAndProfileAppController {

    public ResponseEntity<List<TodoDto> > speedDataService();

    public ResponseEntity<String>  allDeleteService();

    // App Information
    public ResponseEntity<String>  appInformationService(HttpServletRequest request, HttpServletResponse response);

}
