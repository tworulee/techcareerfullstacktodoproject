package com.tugrulyuce.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

// Auditing atabase hangi kullanıcı ne zaman => ne ekledi veya ne güncelledi
abstract public class AuditingAwareBaseDto implements Serializable {

    //Serileştirme
    public static final Long serialVersionUID = 1L;

    private Long id; // ID
    @Builder.Default
    private Date systemDate=new Date(System.currentTimeMillis()); // DATE

    // AUDITING
    @JsonIgnore // backentte giden veriyi saklar
    protected String createdUser;

    @JsonIgnore // backentte giden veriyi saklar
    protected Date createdDate;

    @JsonIgnore // backentte giden veriyi saklar
    protected String updatedUser;

    @JsonIgnore // backentte giden veriyi saklar
    protected Date updatedDate;
}