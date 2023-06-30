package com.tugrulyuce.bean;

import com.tugrulyuce.business.dto.TodoDto;
import com.tugrulyuce.business.service.impl.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// LOMBOK
@RequiredArgsConstructor

@Configuration
public class CommandLineRunnerBean {

    private final TodoServiceImpl todoService;

    @Bean
    public CommandLineRunner commandLineRunnerMethod(){
        return args -> {
                List<TodoDto> list = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    TodoDto todoDto = TodoDto.builder()
                            .todo(UUID.randomUUID().toString())
                            .completed(false)
                            .build();
                    todoService.todoServiceCreate(todoDto);
                    list.add(todoDto);
                }
        }; //end args
    } // end command Line Runner Method
} // end class
