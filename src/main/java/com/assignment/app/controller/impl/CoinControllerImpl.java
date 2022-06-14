/**
 * 
 */
package com.assignment.app.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.app.controller.CoinController;
import com.assignment.app.model.response.CoinResponsePayload;
import com.assignment.app.service.CoinService;

import lombok.AllArgsConstructor;

/**
 * @author ameynaik
 *
 */
@Service
@AllArgsConstructor
public class CoinControllerImpl implements CoinController {

	private final CoinService coinService;
	
	@Override
	public ResponseEntity<CoinResponsePayload> search(String symbol) {
		return ResponseEntity.ok(coinService.search(symbol));
	}
	
	

}
