package com.carrefour.api.application.mapper;

import com.carrefour.api.application.model.DeliveryMethodModel;
import com.carrefour.api.persistence.entity.DeliveryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeliveryMethodMapper {

   // DeliveryMethodModel entityToModel(DeliveryEntity deliveryEntity);

    List<DeliveryMethodModel> entityListToModelList(List<DeliveryEntity> deliveryEntities);

   // DeliveryEntity modelToEntity(DeliveryMethodModel deliveryMethodModel);
}
