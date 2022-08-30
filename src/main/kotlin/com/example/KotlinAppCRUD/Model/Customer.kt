package com.example.KotlinAppCRUD.Model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
// this Data Class kotlin
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long=0 ,

    @get: NotBlank
    val firstname : String="" ,

    @get:NotBlank
    val lastname: String ="",




)
