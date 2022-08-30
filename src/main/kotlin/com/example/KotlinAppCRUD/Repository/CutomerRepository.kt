package com.example.KotlinAppCRUD.Repository

import com.example.KotlinAppCRUD.Model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CutomerRepository : JpaRepository<Customer,Long> {
}