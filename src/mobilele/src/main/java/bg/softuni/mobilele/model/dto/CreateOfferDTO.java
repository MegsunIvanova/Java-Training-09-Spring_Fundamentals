package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.enums.EngineEnum;
import bg.softuni.mobilele.model.enums.TransmissionEnum;
import jakarta.validation.constraints.*;

public class CreateOfferDTO {
    @NotEmpty
    private String description;

    @Positive
    private Integer mileage;

    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;


    @NotEmpty
    private String imageUrl;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    @Min(1900)
    private Integer year;

    public String getDescription() {
        return description;
    }

    public CreateOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public CreateOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public CreateOfferDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public CreateOfferDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CreateOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public CreateOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CreateOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public CreateOfferDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
