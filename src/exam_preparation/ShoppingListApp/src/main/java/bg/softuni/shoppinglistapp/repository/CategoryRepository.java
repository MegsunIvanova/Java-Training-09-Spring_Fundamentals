package bg.softuni.shoppinglistapp.repository;

import bg.softuni.shoppinglistapp.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @EntityGraph(
            value = "categoryWithProducts",
            attributePaths = "products"
    )
    @Query("SELECT c FROM CategoryEntity c")
    List<CategoryEntity> getAllCategoriesWithProducts();
}
