package com.kltn.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_PRODUCT", allocationSize = 1, initialValue=100)
public class Product extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductType productType;

    private String name;

    private String image;

    private Double price;

    private String description;
}
