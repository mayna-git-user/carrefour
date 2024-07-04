package com.carrefour.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "delivery_method")
public class DeliveryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "uuid", unique = true, nullable = false)
	@Basic
	private UUID uuid;

	@Column
	private String name;

}
