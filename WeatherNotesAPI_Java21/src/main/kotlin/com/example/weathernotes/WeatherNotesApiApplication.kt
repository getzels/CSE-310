package com.example.weathernotes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class WeatherNotesApiApplication

fun main(args: Array<String>) {
    runApplication<WeatherNotesApiApplication>(*args)
}
