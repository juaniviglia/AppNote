package services.NoteService;

import entities.Category;
import entities.Note;

import java.util.List;

public interface NoteService {
    void save(Note note);
    void delete(Note note);
    void update(Note note,String title,String description,List<Category> categories);
    Note createNote(Integer idUser, String title, String description, List<Integer> categories);
    Note findById(Integer id);

}
