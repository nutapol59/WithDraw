package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@MappedSuperclass
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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    HH:mm:ss.SSS
    @Column
    private Date documentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approveMapFlow")
    private ApproveMapFlow approveMapFlow;


}
