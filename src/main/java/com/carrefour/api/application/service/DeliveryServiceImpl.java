package com.carrefour.api.application.service;

import com.carrefour.api.application.enumeration.DeliveryMethodEnum;
import com.carrefour.api.application.mapper.DeliveryMethodMapper;
import com.carrefour.api.application.model.DeliveryCommandModel;
import com.carrefour.api.application.model.DeliveryMethodModel;
import com.carrefour.api.persistence.dao.DeliveryRepository;
import com.carrefour.api.persistence.dao.UserDeliveryRepository;
import com.carrefour.api.persistence.entity.DeliveryEntity;
import com.carrefour.api.persistence.entity.UserDeliveryEntity;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.carrefour.api.application.enumeration.DeliveryMethodEnum.*;

/**
 * Service for handle delivery business logic.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    public static final int DRIVE_MIN_VALID_DELIVERY_DAY = 30;
    public static final int DELIVERY_MIN_VALID_DELIVERY_DAY = 5;
    public static final int DELIVERY_TODAY_MIN_VALID_DELIVERY_DAY = 3;
    public static final int DELIVERY_ASAP_MIN_VALID_DELIVERY_DAY = 2;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private UserDeliveryRepository userDeliveryRepository;

   @Autowired
    private DeliveryMethodMapper deliveryMethodMapper;

    @Override
    @Cacheable("delivery_methods")
    public List<DeliveryMethodModel> retrieveAllDeliveryMethods() {
        return deliveryMethodMapper.entityListToModelList(deliveryRepository.findAll());
    }

    @Override
    public void createDeliveryCommand(@NonNull DeliveryCommandModel deliveryCommandModel) {
        Optional<DeliveryEntity> deliveryMethod = deliveryRepository.findByUuid(deliveryCommandModel.getDeliveryUuid());

        if(deliveryMethod.isEmpty()){
            throw new IllegalArgumentException();
        }

        /** function to check validity of delivery method vs date **/
        DeliveryMethodEnum deliveryMethodName = valueOf(deliveryCommandModel.getName());
         if(!isValidDeliveryTimeBox(deliveryMethodName, deliveryCommandModel.getDate())){
            throw new IllegalStateException("the time box input does not suit the delivery method ");
        }

        UserDeliveryEntity userDelivery = new UserDeliveryEntity();
        userDelivery.setDeliveryMethod(deliveryMethod.get());
        userDelivery.setDate(deliveryCommandModel.getDate());
        userDelivery.setUserUuid(userDelivery.getUserUuid());
        userDeliveryRepository.save(userDelivery);
    }

    private boolean isValidDeliveryTimeBox(DeliveryMethodEnum deliveryMethodName, LocalDateTime date) {

        boolean isValidUserTimeBox = true;

        switch (deliveryMethodName) {
            case DRIVE:
                if(date.isAfter(LocalDateTime.now().plusDays(DRIVE_MIN_VALID_DELIVERY_DAY))){
                isValidUserTimeBox = false;
                }
                break;
            case DELIVERY:
                if(date.isAfter(LocalDateTime.now().plusDays(DELIVERY_MIN_VALID_DELIVERY_DAY))) {
                    isValidUserTimeBox = false;
                }
                break;
            case DELIVERY_TODAY:
                if(date.isAfter(LocalDateTime.now().plusDays(DELIVERY_TODAY_MIN_VALID_DELIVERY_DAY))){
                isValidUserTimeBox = false;
            }
            break;
            case DELIVERY_ASAP:
                if(date.isAfter(LocalDateTime.now().plusDays(DELIVERY_ASAP_MIN_VALID_DELIVERY_DAY))){
                isValidUserTimeBox = false;
            }
            break;
            default:
                isValidUserTimeBox = false;
        }
        return isValidUserTimeBox;
    }


}
