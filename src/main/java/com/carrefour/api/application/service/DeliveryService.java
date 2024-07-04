package com.carrefour.api.application.service;

import com.carrefour.api.application.model.DeliveryCommandModel;
import com.carrefour.api.application.model.DeliveryMethodModel;
import com.carrefour.api.presentation.dto.DeliveryMethodDto;

import java.util.List;

public interface DeliveryService {

    List<DeliveryMethodModel> retrieveAllDeliveryMethods();

    void createDeliveryCommand(DeliveryCommandModel deliveryCommandModel);
}
