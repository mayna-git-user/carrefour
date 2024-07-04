package com.carrefour.api.presentation.mapper;

import com.carrefour.api.application.model.DeliveryCommandModel;
import com.carrefour.api.application.model.DeliveryMethodModel;
import com.carrefour.api.presentation.dto.DeliveryCommandDto;
import com.carrefour.api.presentation.dto.DeliveryMethodDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeliveryMapper {

    //DeliveryMethodDto modelToDto(DeliveryMethodModel deliveryMethodModel);

    List<DeliveryMethodDto> modelDeliveryListToDtoModelList(List<DeliveryMethodModel> deliveryMethodModels);

  //  DeliveryMethodDto DtoToModel(DeliveryMethodModel deliveryMethodModel);

    DeliveryCommandModel DtoCommandToModelCommand(DeliveryCommandDto deliveryCommandDto);
}
