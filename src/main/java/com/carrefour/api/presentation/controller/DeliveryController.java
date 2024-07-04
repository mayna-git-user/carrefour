package com.carrefour.api.presentation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.carrefour.api.application.model.DeliveryMethodModel;
import com.carrefour.api.application.service.DeliveryService;
import com.carrefour.api.presentation.dto.DeliveryCommandDto;
import com.carrefour.api.presentation.dto.DeliveryMethodDto;
import com.carrefour.api.presentation.mapper.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:58569")
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;

	@Autowired
	DeliveryMapper deliveryMapper;

	@GetMapping("/methods")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<DeliveryMethodDto>> getAllDeliveryMethods() {
		try {

			List<DeliveryMethodModel> deliveryMethods = deliveryService.retrieveAllDeliveryMethods();


			if (deliveryMethods.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(deliveryMapper.modelDeliveryListToDtoModelList(deliveryMethods), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/command")
	public ResponseEntity<Void> orderDelivery(@RequestBody DeliveryCommandDto deliveryCommand) {
		try {
			if (deliveryCommand.getDeliveryUuid() == null  || deliveryCommand.getUserUuid() == null) {
				throw new IllegalArgumentException();
			}

			deliveryService.createDeliveryCommand(deliveryMapper.DtoCommandToModelCommand(deliveryCommand));

			return new ResponseEntity<>(null, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
