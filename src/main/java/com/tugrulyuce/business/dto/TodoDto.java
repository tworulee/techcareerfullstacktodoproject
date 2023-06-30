package com.tugrulyuce.business.dto;

import com.tugrulyuce.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

// TodoDTo
public class TodoDto extends AuditingAwareBaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Size(min = 10, message = "At least 10 character you should add")
    private String todo;

    private boolean completed;


}
