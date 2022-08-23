package AppNote.common;

import AppNote.dtos.CategoryResponse;
import AppNote.dtos.NoteResponse;
import AppNote.dtos.UserResponse;
import AppNote.entities.Category;
import AppNote.entities.Note;
import AppNote.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryResponse convertCategoryToCategoryResponse(Category c){
        CategoryResponse categoryResponse = modelMapper.map(c,CategoryResponse.class);
        return categoryResponse;
    }
    public NoteResponse convertNoteToNoteResponse(Note n){
        NoteResponse noteResponse = modelMapper.map(n,NoteResponse.class);
        return noteResponse;
    }
    public UserResponse convertUserToUserResponse(User u){
        UserResponse userResponse = modelMapper.map(u,UserResponse.class);
        return userResponse;
    }

}
