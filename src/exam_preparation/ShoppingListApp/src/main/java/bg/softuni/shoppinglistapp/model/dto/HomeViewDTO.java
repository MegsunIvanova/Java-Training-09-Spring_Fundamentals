package bg.softuni.shoppinglistapp.model.dto;

import java.util.List;

public class HomeViewDTO {
    private List<ProductDTO> foods;
    private List<ProductDTO> drinks;
    private List<ProductDTO> households;
    private List<ProductDTO> other;

    public HomeViewDTO(List<ProductDTO> foods,
                       List<ProductDTO> drinks,
                       List<ProductDTO> households,
                       List<ProductDTO> other) {
        this.foods = foods;
        this.drinks = drinks;
        this.households = households;
        this.other = other;
    }
}
