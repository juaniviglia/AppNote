package common;



import controllers.CategorysController;
import controllers.NotesController;
import controllers.UsersController;
import entities.Category;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import services.CategoryService.CategoryService;
import services.NoteService.NoteService;
import services.UserService.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader {
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

    public void run(ApplicationArguments args) throws Exception{
        createUser();
        createCategory();

        List<Integer> categories = new ArrayList();
        categories.add(1);
        categories.add(2);
        categories.add(3);
        categories.add(4);
        createNotes(categories);
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
        notesController.createNote("Important Information","this is impotant information",1,categories);
    }
}
