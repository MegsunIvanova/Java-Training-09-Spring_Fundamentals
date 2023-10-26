package bg.softuni.shoppinglistapp.service.impl;

import bg.softuni.shoppinglistapp.model.dto.HomeViewDTO;
import bg.softuni.shoppinglistapp.model.dto.ProductDTO;
import bg.softuni.shoppinglistapp.model.entity.ProductEntity;
import bg.softuni.shoppinglistapp.model.enums.CategoryName;
import bg.softuni.shoppinglistapp.repository.CategoryRepository;
import bg.softuni.shoppinglistapp.service.CategoryService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HomeViewDTO createHomeViewDTO() {
        Map<String, List<ProductDTO>> productsByCategories = categoryRepository
                .getAllCategoriesWithProducts()
                .stream()
                .collect(Collectors.toMap(category -> category.getName().name(),
                        category -> this.mapToProductDTOs(category.getProducts())));

        return new HomeViewDTO(
                productsByCategories.get(CategoryName.FOOD.name()),
                productsByCategories.get(CategoryName.DRINK.name()),
                productsByCategories.get(CategoryName.HOUSEHOLD.name()),
                productsByCategories.get(CategoryName.OTHER.name()));
    }

    private List<ProductDTO> mapToProductDTOs(Set<ProductEntity> products) {
        return products.stream()
                .map(p -> modelMapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
