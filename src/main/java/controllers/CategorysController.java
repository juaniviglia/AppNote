package controllers;


import common.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.CategoryService.CategoryService;

@RestController
public class CategorysController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @PostMapping("/Categories/create/{description}")
    public ResponseEntity<String> createCategory(@PathVariable String description) throws Exception{
        categoryService.createCategory(description);
        return new ResponseEntity<>("Category succesfully created", HttpStatus.OK);
    }
}
