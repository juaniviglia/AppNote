package services.CategoryService;

import common.EntityDtoConverter;
import dtos.CategoryResponse;
import entities.Category;
import exceptions.CategoryAlreadyCreatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntityDtoConverter entityDtoConverter;


    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category createCategory(String description) {
        Category c = categoryRepository.findByDescription(description);
        if (c == null){
            Category newCategory = Category.builder()
                    .description(description)
                    .build();
            return categoryRepository.save(newCategory);
        }else{
            throw new CategoryAlreadyCreatedException("A Category with this description already exists",entityDtoConverter.convertCategoryToCategoryResponse(c));
        }
    }

    @Override
    public boolean categoryExists(String description) {
        Category cat = categoryRepository.findByDescription(description);
        if(cat == null){
            return false;
        }else{
            return true;
        }

    }

}
