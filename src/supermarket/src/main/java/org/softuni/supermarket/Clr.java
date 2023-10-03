package org.softuni.supermarket;

import org.softuni.supermarket.model.dto.AddCategoryDTO;
import org.softuni.supermarket.model.dto.AddShopDTO;
import org.softuni.supermarket.model.dto.AddTownDTO;
import org.softuni.supermarket.service.CategoryService;
import org.softuni.supermarket.service.ShopService;
import org.softuni.supermarket.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class Clr implements CommandLineRunner {

    private final BufferedReader reader;
    private final CategoryService categoryService;
    private final TownService townService;
    private final ShopService shopService;

    @Autowired
    public Clr(BufferedReader reader, CategoryService categoryService, TownService townService, ShopService shopService) {
        this.reader = reader;
        this.categoryService = categoryService;
        this.townService = townService;
        this.shopService = shopService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hi");

        while (true) {
            System.out.println("Choose option from:" +
                    "\n1 - for Add Category" +
                    "\n2 - for Add Town" +
                    "\n3 - for Add Shop" +
                    "\n4 - for Add Seller" +
                    "\n5 - for Add Product" +
                    "\n6 - for Set seller new manager" +
                    "\n7 - for Distributing product in shops" +
                    "\n8 - for Showing all sellers in Shop" +
                    "\n9 - for Showing all products in Shop");

            String input = reader.readLine();

            switch (input) {
                case "1" -> this.addCategory();
                case "2" -> this.addTown();
                case "3" -> this.addShop();
                case "4" -> this.addSeller();
                case "5" -> this.addProduct();
                case "6" -> this.setManager();
                case "7" -> this.setProductDistribution();
                case "8" -> this.showAllSellersFromShop();
                case "9" -> this.showAllProductsFromShop();
                default -> System.out.println("Option is not correct!");
            }

            System.out.println("==================================");
        }

    }

    private void showAllProductsFromShop() {
    }

    private void showAllSellersFromShop() {
    }

    private void setProductDistribution() {

    }

    private void setManager() {

    }

    private void addProduct() {

    }

    private void addSeller() {

    }

    private void addShop() throws IOException {
        System.out.println("Enter shop details in format: name address town");

        String[] details = reader.readLine().split("\\s+");


        String result = this.shopService.addShop(new AddShopDTO(details));

        System.out.println(result);

    }

    private void addTown() throws IOException {
        System.out.println("Enter town name:");

        String townName = reader.readLine();

        String result = this.townService.addTown(new AddTownDTO(townName));

        System.out.println(result);

    }

    private void addCategory() throws IOException {
        System.out.println("Enter category name:");

        String categoryName = reader.readLine();

        String result = this.categoryService.addCategory(new AddCategoryDTO(categoryName));

        System.out.println(result);

    }
}
