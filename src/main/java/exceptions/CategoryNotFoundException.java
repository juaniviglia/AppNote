package exceptions;

import entities.Category;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message){
        super(message);
    }

}
