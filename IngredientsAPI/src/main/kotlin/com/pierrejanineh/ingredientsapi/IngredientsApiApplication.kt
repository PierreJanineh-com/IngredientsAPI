package com.pierrejanineh.ingredientsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.jetbrains.exposed.sql.*

@SpringBootApplication
class IngredientsApiApplication

fun main(args: Array<String>) {
    runApplication<IngredientsApiApplication>(*args)

    // Initialize database connection
    Database.connect(
        "jdbc:postgresql://localhost:5432/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "123456789"
    )
}
