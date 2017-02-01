package com.ss.base;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@EqualsAndHashCode(of={"id"})
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Version @JsonIgnore
    protected Long version;

    @Column(name = "code")
    protected String code;

    @Column(name = "name")
    protected String name;

    @Column(name = "active")
    protected Integer active;
}
