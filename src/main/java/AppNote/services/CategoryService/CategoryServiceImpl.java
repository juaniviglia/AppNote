package AppNote.services.CategoryService;

import AppNote.common.EntityDtoConverter;
import AppNote.entities.Category;
import AppNote.exceptions.CategoryAlreadyCreatedException;
import AppNote.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import AppNote.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public Category findById(Integer idCategory) {
        if(categoryRepository.findById(idCategory).isPresent()){
            return categoryRepository.findById(idCategory).get();
        }
        throw new CategoryNotFoundException("The ID does not match any category");
    }

    @Override
    public List<Category> findByIds(List<Integer> idCategories) {
        List<Category> categories = new ArrayList<>();
        for(Integer i:idCategories){
            categories.add(findById(i));
        }
        return categories;
    }

}
