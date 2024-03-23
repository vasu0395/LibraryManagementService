package com.example.librarymanagementsystem.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Builder.Default
    @Column(name = "isLibrarian")
    private Boolean isLibrarian = false;
    @Column(name = "accessCardNumber")
    private Integer accessCardNumber;
}
