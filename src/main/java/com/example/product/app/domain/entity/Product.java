package com.example.product.app.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
