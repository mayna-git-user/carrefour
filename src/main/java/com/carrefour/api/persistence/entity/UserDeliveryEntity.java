package com.carrefour.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tutorials")
public class UserDeliveryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**the functional id of the userDelivery entry**/
	@Column(name = "uuid", unique = true, nullable = false)
	@Basic
	private UUID uuid;

	/**the functional id of the user or customer**/
	@Column(name = "user_uuid", unique = false, nullable = false)
	@Basic
	private UUID UserUuid;

	/** Reference to the delivery method **/
	@OneToOne
	@JoinColumn(name = "delivery_id", nullable = false)
	private DeliveryEntity DeliveryMethod;

	@Column(name = "order_date")
	private LocalDateTime date;



}
