package bg.softuni.intro.cats.model.dto;

import java.util.List;

public class CreateOwnerDTO {
    private String name;
    private List<String> catNames;

    public String getName() {
        return name;
    }

    public CreateOwnerDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getCatNames() {
        return catNames;
    }

    public CreateOwnerDTO setCatNames(List<String> catNames) {
        this.catNames = catNames;
        return this;
    }
}
