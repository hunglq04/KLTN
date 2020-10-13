package com.kltn.sms.model;

import com.kltn.sms.constant.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee stylist;

    @ManyToOne(fetch = FetchType.LAZY)
    private Salon salon;

    @Column
    private LocalDate date;

    @Column
    private LocalTime time;

    @Column
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column
    private Double rating;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "booking_service",
            joinColumns = {@JoinColumn( name = "booking_id")},
            inverseJoinColumns = {@JoinColumn( name = "service_id")}
    )
    private List<Service> services;
}
