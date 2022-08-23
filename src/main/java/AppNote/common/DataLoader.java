package AppNote.common;



import AppNote.controllers.CategorysController;
import AppNote.controllers.NotesController;
import AppNote.controllers.UsersController;
import AppNote.entities.User;
import AppNote.services.CategoryService.CategoryService;
import AppNote.services.NoteService.NoteService;
import AppNote.services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private NoteService noteService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotesController notesController;

    @Autowired
    private UsersController usersController;

    @Autowired
    private CategorysController categorysController;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        System.out.println("HOLA 1");
        createUser();
        createCategory();

        List<Integer> categories = new ArrayList();
        categories.add(1);
        categories.add(2);
        categories.add(3);
        categories.add(4);
        createNotes(categories);
        System.out.println("ENTRE AL DATA LOADER");
    }

    private void createUser(){
        User user = User.builder()
                .username("Envolvers")
                .password(("envolvers"))
                .build();
        userService.save(user);
    }
    private void createCategory(){
        try {
            categorysController.createCategory("TODAY");
            categorysController.createCategory("OK");
            categorysController.createCategory("IMP");
            categorysController.createCategory("LOOK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createNotes(List<Integer> categories){
        notesController.createNote("Hola","hola",1,categories);
    }
}
