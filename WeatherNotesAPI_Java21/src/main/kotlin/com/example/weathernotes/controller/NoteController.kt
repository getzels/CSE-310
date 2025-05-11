package com.example.weathernotes.controller

import com.example.weathernotes.model.Note
import com.example.weathernotes.service.WeatherNoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(private val service: WeatherNoteService) {

    @PostMapping
    fun createNote(@RequestParam city: String, @RequestBody content: String): Note {
        return service.createNote(city, content)
    }

    @GetMapping
    fun getAllNotes(): List<Note> = service.getAllNotes()
}
