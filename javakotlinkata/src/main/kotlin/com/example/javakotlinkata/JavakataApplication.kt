package com.example.javakotlinkata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavakataApplication

fun main(args: Array<String>) {
	runApplication<JavakataApplication>(*args)
}
