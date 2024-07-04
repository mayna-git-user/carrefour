package com.carrefour.api.application.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DeliveryCommandModel {

   /** unique functional identifiant for delivery method **/
	private UUID DeliveryUuid;

	/** name of delivery method **/
	private String name;

	/** unique functional identifiant for user**/
	private UUID userUuid;

	/** date for delivery **/
	private LocalDateTime date;

}
