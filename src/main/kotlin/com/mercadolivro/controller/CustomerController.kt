package com.mercadolivro.controller

import com.mercadolivro.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController // classe controladora
@RequestMapping("customer") //caminho, no localhost ficaria http://localhost:8080/customer
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAll(): List<CustomerModel> {
        return customers

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {

        var id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()




        customers.add(CustomerModel(id, customer.name, customer.email))
        //   println(customer)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String,@RequestBody customer: PutCustomerRequest) {
     customers.filter { it.id == id }.first().let {
        it.name = customer.name
         it.email = customer.email
     }
}
}
