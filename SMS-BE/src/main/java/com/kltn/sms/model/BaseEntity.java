package com.kltn.sms.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
@Data
class BaseEntity implements Serializable {
    @Id@GeneratedValue
    private Long id;
    @Version
    private Long version;
}
