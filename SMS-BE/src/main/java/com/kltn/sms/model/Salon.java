package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Salon extends BaseEntity {
    @Column
    private String street;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ward ward;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;
}
