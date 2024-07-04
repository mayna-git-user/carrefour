package com.carrefour.api.presentation.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DeliveryCommandDto {

   /** unique functional identifiant for delivery method **/
	private UUID deliveryUuid;

	/** name of delivery method **/
	private String name;

	/** date for delivery **/
	private LocalDateTime date;

	/** user or ccustomer id**/
	private UUID userUuid;

}
