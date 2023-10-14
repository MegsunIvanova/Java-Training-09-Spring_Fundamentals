package org.softuni.reseller.service.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.softuni.reseller.model.dto.AddOfferDTO;
import org.softuni.reseller.model.dto.HomeModelDTO;
import org.softuni.reseller.model.dto.OfferDTO;
import org.softuni.reseller.model.entity.Condition;
import org.softuni.reseller.model.entity.Offer;
import org.softuni.reseller.model.entity.User;
import org.softuni.reseller.repository.ConditionRepository;
import org.softuni.reseller.repository.OfferRepository;
import org.softuni.reseller.repository.UserRepository;
import org.softuni.reseller.service.OfferService;
import org.softuni.reseller.service.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean createOffer(AddOfferDTO addOfferDTO) {

        Optional<Condition> conditionOpt = this.conditionRepository
                .findByName(addOfferDTO.getCondition());


        Optional<User> userOpt = this.userRepository
                .findByUsername(loggedUser.getUsername());

        if(conditionOpt.isEmpty() || userOpt.isEmpty()) {
            return false;
        }

        Offer offer = new Offer()
                .setDescription(addOfferDTO.getDescription())
                .setPrice(addOfferDTO.getPrice())
                .setCondition(conditionOpt.get())
                .setSeller(userOpt.get());

        offerRepository.save(offer);

        return true;
    }

    @Override
    @Transactional
    public void buyOffer(UUID offerId) {
        User buyer = userRepository
                .findByUsername(loggedUser.getUsername())
                .orElseThrow();

        Offer offer = offerRepository
                .findById(offerId)
                .orElseThrow();

        User seller = offer.getSeller();

        seller.getOffers().remove(offer);
        offer.setSeller(null);
        offer.setBuyer(buyer);
        buyer.getBoughtOffers().add(offer);

        this.offerRepository.save(offer);
        this.userRepository.saveAll(List.of(seller, buyer));
    }

    @Override
    public void removeOffer(UUID id) {
        Offer toDelete = this.offerRepository.findById(id)
                .orElseThrow();
        this.offerRepository.delete(toDelete);
    }

    @Override
    @Transactional
    public HomeModelDTO getHomeModelDTO() {

        List<Offer> allOffers = offerRepository.findAllOffers();

        List<OfferDTO> myOffers = new ArrayList<>();
        List<OfferDTO> boughtOffers = new ArrayList<>();
        List<OfferDTO> otherOffers = new ArrayList<>();

        String loggedUserUsername = loggedUser.getUsername();


        for (Offer offer : allOffers) {
            OfferDTO offerDTO = modelMapper.map(offer, OfferDTO.class);
            String seller = offerDTO.getSellerUsername();
            String buyer = offerDTO.getBuyerUsername();

            if (seller != null && buyer == null) {
                if (seller.equals(loggedUserUsername)) {
                    myOffers.add(offerDTO);
                } else {
                    otherOffers.add(offerDTO);
                }
            } else if (buyer != null && buyer.equals(loggedUserUsername)) {
                boughtOffers.add(offerDTO);
            }
        }

        return new HomeModelDTO()
                .setLoggedUsername(loggedUserUsername)
                .setOffers(myOffers)
                .setBoughtOffers(boughtOffers)
                .setOtherOffers(otherOffers);
    }
}
