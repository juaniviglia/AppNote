package controllers;


import common.EntityDtoConverter;
import dtos.NoteResponse;
import entities.Category;
import entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CategoryService.CategoryService;
import services.NoteService.NoteService;

import java.util.List;

@RestController
public class NotesController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/Notes/create/{title}/{description}/{idUsuario}/{idCategories}")
    public ResponseEntity<NoteResponse> createNote(@PathVariable String title, @PathVariable String description, @PathVariable Integer idUser, @PathVariable List<Integer> idCategories){
        return new ResponseEntity<>(entityDtoConverter.convertNoteToNoteResponse(noteService.createNote(idUser,title,description,idCategories)), HttpStatus.OK);
    }
    @PutMapping("/Notes/edit/{idNote/{title}/{description}/{idCategories}")
    public ResponseEntity<String> updateNote(@PathVariable Integer idNote,@PathVariable String title,@PathVariable String description,@PathVariable List<Integer> idCategories){
        List<Category> categories = categoryService.findByIds(idCategories);
        Note note = noteService.findById(idNote);
        noteService.update(note,title,description,categories);
        return new ResponseEntity<>("Note updated succesfully",HttpStatus.OK);
    }
    @DeleteMapping("/Notes/delete/{idNote}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Integer idNote){
        Note note = noteService.findById(idNote);
        noteService.delete(note);
        return new ResponseEntity<>("Note deleted succesfully",HttpStatus.OK);
    }


}
