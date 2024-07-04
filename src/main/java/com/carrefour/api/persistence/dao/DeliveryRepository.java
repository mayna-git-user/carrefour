package com.carrefour.api.persistence.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrefour.api.persistence.entity.DeliveryEntity;
import org.springframework.stereotype.Component;


public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {
  //List<DeliveryEntity> findByPublished(boolean published);

 // List<DeliveryEntity> findByTitleContaining(String title);

  List<DeliveryEntity> findAll();

  Optional<DeliveryEntity> findByUuid(UUID uuid);
}
