package services.CategoryService;

import entities.Category;

public interface CategoryService {
    void save(Category category);
    void delete(Category category);
    void update(Category category);
    Category createCategory(String category);
    boolean categoryExists(String category);
}
