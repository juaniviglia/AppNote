package repositories;

import entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByDescription(String desctiption);
    List<Category> findByIds(List<Integer> idCategories);
}
