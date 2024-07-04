package com.carrefour.test.configuration;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/** Default class for all unit tests */
public abstract class UnitTesting {

  /** Pojo Data Mocker instance */
  protected PodamFactory podamFactory = new PodamFactoryImpl();
}
