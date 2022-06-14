package com.assignment.app.model.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinDetails {

	@Schema(name="coin-symbol" , description="name of symbol" , example="BTCTUSD, ETHTUSD, LTCBTC, BNBBTC, DOGEUSDT, SOLAUD")
	@JsonProperty("coin-symbol")
	String coinSymbol;
	
	@Schema(name="price" , description="price of the coin-symbol" , example="3.65")
	String price;
}
