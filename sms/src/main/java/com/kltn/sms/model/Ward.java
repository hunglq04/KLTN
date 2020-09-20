package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ward extends BaseEntity {
    @Column
    private String name;

    @Column
    private String prefix;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

}
