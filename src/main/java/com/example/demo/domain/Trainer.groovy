package com.example.demo.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "trainers")
class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    String name

    @Min(1)
    @Max(5)
    @NotBlank(message = "Level is mandatory")
    @Column(nullable = false)
    Short level
}

