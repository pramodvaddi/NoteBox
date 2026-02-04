package com.pramodvaddiraju.notebox.service;

import com.pramodvaddiraju.notebox.dto.NoteRequestDTO;
import com.pramodvaddiraju.notebox.dto.NoteResponseDTO;
import com.pramodvaddiraju.notebox.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {

    NoteResponseDTO createNote(NoteRequestDTO noteRequestDTO);
    Page<NoteResponseDTO> getAllNotes(Pageable pageable);
    NoteResponseDTO getNoteById(int id);
    void deleteNoteById(int id);

}
