package com.pramodvaddiraju.notebox.controller;

import com.pramodvaddiraju.notebox.dto.NoteRequestDTO;
import com.pramodvaddiraju.notebox.dto.NoteResponseDTO;
import com.pramodvaddiraju.notebox.service.NoteService;
import com.pramodvaddiraju.notebox.service.NoteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    ResponseEntity<NoteResponseDTO> createNote(@Valid @RequestBody NoteRequestDTO noteRequestDTO){
        return ResponseEntity.status(201).body(noteService.createNote(noteRequestDTO));
    }

    @GetMapping
    ResponseEntity<Page<NoteResponseDTO>> getAllNotes(Pageable pageable){
        return ResponseEntity.ok(noteService.getAllNotes(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<NoteResponseDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable int id){
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
