package com.tugrulyuce.business.service.impl.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// JSON
@JsonIgnoreProperties(value = {"created_date,updated_date"},allowGetters = true) // Json'a emir veriyoruz bunları takip etme

@Entity
@Table(name="todoList")
public class TodoEntity  implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "todo")
    private String todo;

    @Column(name = "completed")
    private boolean completed;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date systemDate;

}
