package com.carrefour.api.persistence.dao;

import com.carrefour.api.persistence.entity.DeliveryEntity;
import com.carrefour.api.persistence.entity.UserDeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserDeliveryRepository extends JpaRepository<UserDeliveryEntity, Long> {

}
