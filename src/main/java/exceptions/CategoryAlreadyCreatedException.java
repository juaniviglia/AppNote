package exceptions;

import dtos.CategoryResponse;

public class CategoryAlreadyCreatedException extends RuntimeException {

    private CategoryResponse category;

    public CategoryAlreadyCreatedException(String message,CategoryResponse category){
        super(message);
        this.category = category;
    }
    public CategoryResponse getCategory() { return category; }
}
