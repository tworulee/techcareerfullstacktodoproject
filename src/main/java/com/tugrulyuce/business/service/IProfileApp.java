package com.tugrulyuce.business.service;

import com.tugrulyuce.business.dto.TodoDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface IProfileApp {

    public List<TodoDto> speedDataService();

    public String allDeleteService();

    // App Information
    public String appInformationService(HttpServletRequest request, HttpServletResponse response);
}
