package com.carrefour.api.application.service;

import com.carrefour.api.application.mapper.DeliveryMethodMapper;
import com.carrefour.api.application.model.DeliveryCommandModel;
import com.carrefour.api.application.model.DeliveryMethodModel;
import com.carrefour.api.persistence.dao.DeliveryRepository;
import com.carrefour.api.persistence.dao.UserDeliveryRepository;
import com.carrefour.api.persistence.entity.DeliveryEntity;
import com.carrefour.api.persistence.entity.UserDeliveryEntity;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service for handle delivery business logic.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {


    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private UserDeliveryRepository userDeliveryRepository;

   @Autowired
    private DeliveryMethodMapper deliveryMethodMapper;

    @Override
    public List<DeliveryMethodModel> retrieveAllDeliveryMethods() {
        return deliveryMethodMapper.entityListToModelList(deliveryRepository.findAll());
    }

    @Override
    public void createDeliveryCommand(@NonNull DeliveryCommandModel deliveryCommandModel) {
        Optional<DeliveryEntity> deliveryMethod = deliveryRepository.findByUuid(deliveryCommandModel.getDeliveryUuid());

        if(deliveryMethod.isEmpty()){
            throw new IllegalArgumentException();
        }

        /** function to check validity of delivery method vs date**/
        // if(!isValidDeliveryTimeBox(deliveryCommandModel.name, deliveryCommandModel.date)
        // throws illigalStateException

        UserDeliveryEntity userDelivery = new UserDeliveryEntity();
        userDelivery.setDeliveryMethod(deliveryMethod.get());
        userDelivery.setDate(deliveryCommandModel.getDate());
        userDelivery.setUserUuid(userDelivery.getUserUuid());
        userDeliveryRepository.save(userDelivery);
    }
}
