package com.pierrejanineh.ingredientsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IngredientsApiApplication

fun main(args: Array<String>) {
    runApplication<IngredientsApiApplication>(*args)
}
