package com.carrefour.test.service;
import com.carrefour.api.application.model.DeliveryMethodModel;
import com.carrefour.api.application.service.DeliveryService;
import com.carrefour.api.application.service.DeliveryServiceImpl;
import com.carrefour.test.configuration.UnitTesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DeliveryServiceImplTest extends UnitTesting {


  @InjectMocks private DeliveryService deliveryService;
  List<String> authorisedDeliveryMethodList ;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    authorisedDeliveryMethodList = Arrays.asList("DRIVE","DELIVERY","DELIVERY_TODAY", "DELIVERY_ASAP");
  }

  @Test
  void getAll_shouldReturnBrandList() {

    List<String> retrievedBrandList = deliveryService.retrieveAllDeliveryMethods().stream().map(delivery -> delivery.getName()).collect(Collectors.toList());
    Assertions.assertNotNull(retrievedBrandList);
    Assertions.assertEquals(authorisedDeliveryMethodList.size(), retrievedBrandList.size());
    Assertions.assertEquals(retrievedBrandList, authorisedDeliveryMethodList);
  }
}
