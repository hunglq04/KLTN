package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class District extends BaseEntity {
    @Column
    private String name;

    @Column
    private String prefix;

    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

}
