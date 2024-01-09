package com.ibm.academia.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"firstRegisterDate","lastUpdatedDate"})
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "age",nullable = false)
    private String age;
    @Column(name = "email",nullable = false)
    private String email;
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
