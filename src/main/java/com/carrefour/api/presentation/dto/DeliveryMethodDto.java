package com.carrefour.api.presentation.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DeliveryMethodDto {

   /** unique functional identifiant for delivery method **/
	private UUID uuid;

	/** name of delivery method **/
	private String name;

}
