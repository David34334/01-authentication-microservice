package com.jdar.store.authentication.dataprovider.jpa.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String name;

    @Column(name = "CUSTOMER_EMAIL", nullable = false)
    private String email;

    @Column(name = "CUSTOMER_AGE", nullable = false)
    private int age;

    @Column(name = "CUSTOMER_ADDRESS", nullable = false)
    private String address;

    @Column(name = "CUSTOMER_PASSWORD", nullable = false)
    private String password;

}
