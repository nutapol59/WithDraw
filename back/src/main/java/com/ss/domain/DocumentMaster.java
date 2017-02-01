package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@MappedSuperclass
@AllArgsConstructor
public class DocumentMaster {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version @JsonIgnore
    private Long version;

    @Column
    private String documentNumber;

    @Column
    private String documentStatus;

    @Column
    private Integer approveSeq;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
    @Column
    private Date documentDate;
}
