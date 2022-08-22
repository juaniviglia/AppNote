package services.CategoryService;

import entities.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    void delete(Category category);
    void update(Category category);
    Category createCategory(String category);
    boolean categoryExists(String category);
    Category findById(Integer idCategory);
    List<Category> findByIds(List<Integer> idCategories);
}
