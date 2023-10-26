package bg.softuni.shoppinglistapp.init;

import bg.softuni.shoppinglistapp.model.entity.CategoryEntity;
import bg.softuni.shoppinglistapp.model.enums.CategoryName;
import bg.softuni.shoppinglistapp.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeed implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategorySeed(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<CategoryEntity> categories = Arrays
                    .stream(CategoryName.values())
                    .map(CategoryEntity::new)
                    .toList();

            categoryRepository.saveAll(categories);
        }
    }
}
