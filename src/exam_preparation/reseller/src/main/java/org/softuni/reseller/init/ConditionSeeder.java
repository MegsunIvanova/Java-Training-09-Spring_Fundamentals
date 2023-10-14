package org.softuni.reseller.init;

import org.softuni.reseller.model.entity.Condition;
import org.softuni.reseller.model.enums.ConditionNameEnum;
import org.softuni.reseller.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ConditionSeeder implements CommandLineRunner {

    private final ConditionRepository conditionRepository;

    public ConditionSeeder(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.conditionRepository.count() == 0) {
            List<Condition> conditions = Arrays.stream(ConditionNameEnum.values())
                    .map(Condition::new)
                    .toList();

            this.conditionRepository.saveAll(conditions);
        }
    }
}
