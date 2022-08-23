package AppNote.services.NoteService;

import AppNote.entities.Category;
import AppNote.entities.Note;

import java.util.List;

public interface NoteService {
    void save(Note note);
    void delete(Note note);
    void update(Note note,String title,String description,List<Category> categories);
    Note createNote(String title, String description,Integer idUser, List<Integer> categories);
    Note findById(Integer id);

}
