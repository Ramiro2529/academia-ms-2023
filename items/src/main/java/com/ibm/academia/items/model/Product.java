package com.ibm.academia.items.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"firstRegisterDate","lastUpdatedDate"})
public class Product implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Column(name = "stock",nullable = false)
    private Integer stock;

    @Column(name = "first_register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstRegisterDate;
    @Column(name = "last_updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastUpdatedDate;

    @PrePersist
    private void beforePersist() {
        this.firstRegisterDate = new Date();
    }

}
