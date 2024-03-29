package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Long price;

    @Column
    private Integer duration;

    @Column
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceType serviceType;

}
