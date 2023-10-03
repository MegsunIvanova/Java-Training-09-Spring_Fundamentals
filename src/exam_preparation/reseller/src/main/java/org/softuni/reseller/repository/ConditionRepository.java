package org.softuni.reseller.repository;

import org.softuni.reseller.model.entity.Condition;
import org.softuni.reseller.model.entity.Offer;
import org.softuni.reseller.model.enums.ConditionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {

      Optional<Condition> findByName (ConditionNameEnum name);

}
