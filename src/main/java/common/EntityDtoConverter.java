package common;

import dtos.CategoryResponse;
import dtos.NoteResponse;
import dtos.UserResponse;
import entities.Category;
import entities.Note;
import entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
