package com.assignment.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.app.model.response.CoinResponsePayload;

import static com.assignment.app.constant.Constants.EndPoints.COIN_V1_ENDPOINT;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Coins Controller", description = "Coins Controller manage the prices")
@RequestMapping(COIN_V1_ENDPOINT)
public interface CoinController {

	@Operation(summary = "Fetches the details of coins specifed in the query")
	@GetMapping
    ResponseEntity<CoinResponsePayload> search(@Parameter(allowEmptyValue=true,example="BTCTUSD", description="BTCTUSD, ETHTUSD, LTCBTC, BNBBTC, DOGEUSDT, SOLAUD" , required=false)  String symbol);
	
}
