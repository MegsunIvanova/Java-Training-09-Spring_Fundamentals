package org.softuni.reseller.service.impl;

import jakarta.transaction.Transactional;
import org.softuni.reseller.model.dto.AddOfferDTO;
import org.softuni.reseller.model.entity.Condition;
import org.softuni.reseller.model.entity.Offer;
import org.softuni.reseller.model.entity.User;
import org.softuni.reseller.repository.ConditionRepository;
import org.softuni.reseller.repository.OfferRepository;
import org.softuni.reseller.repository.UserRepository;
import org.softuni.reseller.service.OfferService;
import org.softuni.reseller.service.UserService;
import org.softuni.reseller.util.UserSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;

    public OfferServiceImpl(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, UserService userService, UserSession userSession) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    @Override
    public void createOffer(AddOfferDTO addOfferDTO) {

        Condition condition = this.conditionRepository
                .findByName(addOfferDTO.getCondition())
                .orElseThrow();

        User seller = this.userRepository.findById(userSession.getId())
                .orElseThrow();


        Offer offer = new Offer()
                .setDescription(addOfferDTO.getDescription())
                .setPrice(addOfferDTO.getPrice())
                .setCondition(condition)
                .setSeller(seller);

        offerRepository.save(offer);

    }

    @Override
    @Transactional
    public void buyOffer(Long offerId) {
        User buyer = this.userRepository.findById(userSession.getId())
                .orElseThrow();

        Offer offer = this.offerRepository.findById(offerId)
                .orElseThrow();

        User seller = offer.getSeller();

        seller.getOffers().remove(offer);
        offer.setBuyer(buyer);
        buyer.getBoughtOffers().add(offer);

        this.offerRepository.save(offer);
        this.userRepository.saveAll(List.of(seller, buyer));

    }
}
