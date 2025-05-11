package com.example.weathernotes.service

import com.example.weathernotes.model.Note
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.concurrent.atomic.AtomicInteger

@Service
class WeatherNoteService {

    private val notes = mutableListOf<Note>()
    private val counter = AtomicInteger()

    fun createNote(city: String, content: String): Note {
        val weather = fetchWeather(city)
        val note = Note(counter.incrementAndGet(), city, content, weather)
        notes.add(note)
        return note
    }

    fun getAllNotes(): List<Note> = notes

    private fun fetchWeather(city: String): String {
        val apiKey = "f9bb398c42a5e0db7ee5d8fa04b70bde"
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey&units=metric"
        val restTemplate = RestTemplate()
        val response = restTemplate.getForObject(url, Map::class.java)
        return response?.get("weather")?.toString() ?: "Unknown"
    }
}
