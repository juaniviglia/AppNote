package AppNote.services.NoteService;


import AppNote.common.EntityDtoConverter;
import AppNote.entities.Category;
import AppNote.entities.Note;
import AppNote.repositories.UserRepository;
import AppNote.services.CategoryService.CategoryService;
import AppNote.exceptions.NoteAlreadyCreatedException;
import AppNote.exceptions.NoteNotFoundException;
import AppNote.services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import AppNote.repositories.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void delete(Note note) {
        noteRepository.delete(note);
    }

    @Override
    public void update(Note note,String title,String description,List<Category> categories) {
        note.setTitle(title);
        //note.setCategories(categories);
        note.setDescription(description);
        noteRepository.save(note);
    }

    @Override
    public Note createNote(String title, String description,Integer idUser, List<Integer> idCategories) {
       Note n = noteRepository.findByTitle(title);
        List<Category> categories = categoryService.findByIds(idCategories);
       if (n == null){
            Note newNote = Note.builder()
                    .title(title)
                    .description(description)
                    //.categories(categories)
                    .condition(true)
                    .lastEdition(LocalDateTime.now())
                    .user(userService.findById(idUser))
                    .build();
            return noteRepository.save(newNote);
        }else{
            throw new NoteAlreadyCreatedException("A Note with this title already exists",entityDtoConverter.convertNoteToNoteResponse(n));
        }
    }

    @Override
    public Note findById(Integer idNote) {
        if(noteRepository.findById(idNote).isPresent()){
            return noteRepository.findById(idNote).get();
        }else{
            throw new NoteNotFoundException("The ID does not match any Note");
        }

    }
}
