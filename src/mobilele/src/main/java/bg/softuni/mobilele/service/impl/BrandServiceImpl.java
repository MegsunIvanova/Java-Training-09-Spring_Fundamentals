package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.BrandDTO;
import bg.softuni.mobilele.model.dto.ModelDTO;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandService {
    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        Map<String, BrandDTO> brands = new TreeMap<>();

        for (ModelEntity model : modelRepository.findAll()) {
            String brandName = model.getBrand().getName();
            if (!brands.containsKey(brandName)) {
                brands.put(brandName, new BrandDTO(brandName, new ArrayList<>()));
            }

            ModelDTO modelDTO = new ModelDTO(model.getId(), model.getName());

            brands.get(brandName).models().add(modelDTO);

        }

        return brands.values().stream().toList();
    }
}
