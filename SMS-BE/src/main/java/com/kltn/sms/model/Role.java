package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ROLE", allocationSize = 1, initialValue = 100)
public class Role extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @Override
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    public Long getId() {
        return super.getId();
    }
}
