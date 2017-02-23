package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DocumentApprove {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approver")
    private AppUser approver;

    @Column
    private Integer sequence;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travelExpenseDocApprove")
    private TravelExpense travelExpense;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentApprove that = (DocumentApprove) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(version, that.version) &&
                Objects.equals(approver, that.approver) &&
                Objects.equals(sequence, that.sequence) &&
                Objects.equals(travelExpense, that.travelExpense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, approver, sequence, travelExpense);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DocumentApprove{");
        sb.append("id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", approver=").append(approver.getId());
        sb.append(", sequence=").append(sequence);
        sb.append(", travelExpense=").append(travelExpense.getId());
        sb.append('}');
        return sb.toString();
    }
}
