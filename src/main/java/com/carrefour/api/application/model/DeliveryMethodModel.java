package com.carrefour.api.application.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DeliveryMethodModel {

   /** unique functional identifiant for delivery method **/
	private UUID uuid;

	/** name of delivery method **/
	private String name;

	/** date for delivery **/
	private LocalDateTime date;

}
