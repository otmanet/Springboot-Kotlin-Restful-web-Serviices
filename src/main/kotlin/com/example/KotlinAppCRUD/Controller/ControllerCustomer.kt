package com.example.KotlinAppCRUD.Controller

import com.example.KotlinAppCRUD.Model.Customer
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.KotlinAppCRUD.Repository.CutomerRepository;
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@RestController
@RequestMapping("/api")
//this class Kotlin
class ControllerCustomer(private  val  customerRepository: CutomerRepository) {

    @GetMapping("/customers")
    fun getAllCustomers(): List<Customer> =
        customerRepository.findAll()

    @PostMapping("/customers")
    fun createNewCustomer(@Valid @RequestBody customer: Customer): Customer =
        customerRepository.save(customer)

    @GetMapping("/customer/{id}")
    fun getArticleById(@PathVariable(value = "id") customerId: Long): ResponseEntity<Customer> {
        return customerRepository.findById(customerId).map { customer ->
            ResponseEntity.ok(customer)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/customers/{id}")
    fun DeleteCustomerbyId(@PathVariable(value = "id") customerId: Long): ResponseEntity<Void> {
        return customerRepository.findById(customerId).map { customer ->
            customerRepository.delete(customer)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/customers/{id}")
    fun  updateCustomersById(@PathVariable(value = "id") customerId:Long,@Valid @RequestBody newCustomer:Customer):ResponseEntity<Customer>{
        return  customerRepository.findById(customerId).map { existinCustomer->
            val updateCustomer:Customer=existinCustomer.copy(firstname = newCustomer.firstname, lastname = newCustomer.lastname)
            ResponseEntity.ok().body(customerRepository.save(updateCustomer))
        }.orElse(ResponseEntity.notFound().build())
    }
}