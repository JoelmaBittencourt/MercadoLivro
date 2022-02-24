package com.mercadolivro.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController // classe controladora
@RequestMapping("customer") //caminho, no localhost ficaria http://localhost:8080/customer
class CustomerController {

    @GetMapping
    fun helloWord(): String {
        return "Hello word"
    }

    @GetMapping("/2") // diferenciar o caminho
    fun customer2(): String {
        return "Ola, mundo"
    }
}