package com.pramodvaddiraju.notebox.service;

import com.pramodvaddiraju.notebox.dto.NoteRequestDTO;
import com.pramodvaddiraju.notebox.dto.NoteResponseDTO;
import com.pramodvaddiraju.notebox.entity.Note;
import com.pramodvaddiraju.notebox.exceptions.ResourceNotFoundException;
import com.pramodvaddiraju.notebox.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{

    private NoteRepository noteRepository;
    private ModelMapper modelMapper;


    public NoteServiceImpl(NoteRepository noteRepository, ModelMapper modelMapper){
        this.noteRepository = noteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public NoteResponseDTO createNote(NoteRequestDTO noteRequestDTO) {
        // Request to entity
        Note note = modelMapper.map(noteRequestDTO, Note.class);

        // entity to db
        Note savedNote = noteRepository.save(note);
        return modelMapper.map(savedNote, NoteResponseDTO.class);
    }

    @Override
    public Page<NoteResponseDTO> getAllNotes(Pageable pageable) {
        return noteRepository.findAll(pageable).map(note -> modelMapper.map(note, NoteResponseDTO.class));
    }

    @Override
    public NoteResponseDTO getNoteById(int id) {
       Note note =  noteRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Not found with id: " + id)
        );
        return modelMapper.map(note, NoteResponseDTO.class);
    }

    @Override
    public void deleteNoteById(int id) {
        noteRepository.deleteById(id);

    }
}
