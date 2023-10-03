package org.softuni.supermarket.service.impl;

import org.softuni.supermarket.model.dto.AddTownDTO;
import org.softuni.supermarket.model.entity.Category;
import org.softuni.supermarket.model.entity.Town;
import org.softuni.supermarket.repository.TownRepository;
import org.softuni.supermarket.service.TownService;
import org.softuni.supermarket.util.ValidationUtil;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ValidationUtil validator;

    public TownServiceImpl(TownRepository townRepository, ValidationUtil validator) {
        this.townRepository = townRepository;
        this.validator = validator;
    }

    @Override
    public String addTown(AddTownDTO addTownDTO) {
        if (this.validator.isValid(addTownDTO)) {
            Town town = new Town()
                    .setName(addTownDTO.getName());

            this.townRepository.save(town);

            return "Successfully added town!";

        } else {
            return this.validator.getViolationsMessages(addTownDTO);
        }
    }
}
