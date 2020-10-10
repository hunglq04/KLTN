package com.kltn.sms.model;

import com.kltn.sms.constant.OrderStatus;
import com.kltn.sms.constant.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ORDER", allocationSize = 1, initialValue=100)
@Table(name = "\"ORDER\"")
public class Order extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Double total;
}
