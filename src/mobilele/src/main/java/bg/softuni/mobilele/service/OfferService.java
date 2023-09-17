package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.AddOfferDTO;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, CurrentUser currentUser, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {
        OfferEntity newOffer = this.offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        //TODO - current user should be logged in

        UserEntity userEntity = this.userRepository.findByEmail(currentUser.getEmail())
                .orElseThrow();

        ModelEntity modelEntity = this.modelRepository.findById(addOfferDTO.getModelId())
                .orElseThrow();

        newOffer.setModel(modelEntity)
                .setSeller(userEntity);

        this.offerRepository.save(newOffer);

    }

}
