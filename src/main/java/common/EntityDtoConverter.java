package common;

import dtos.CategoryResponse;
import entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryResponse convertCategoryToCategoryResponse(Category c){
        CategoryResponse categoryResponse = modelMapper.map(c,CategoryResponse.class);
        return categoryResponse;
    }

}
