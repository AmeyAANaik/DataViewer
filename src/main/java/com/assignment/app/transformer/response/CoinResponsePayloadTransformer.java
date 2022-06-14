package com.assignment.app.transformer.response;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.assignment.app.model.CoinDTO;
import com.assignment.app.model.response.CoinDetails;
import com.assignment.app.model.response.CoinResponsePayload;

@Component
public class CoinResponsePayloadTransformer implements Function<List<CoinDTO>, CoinResponsePayload> {

	@Override
	public CoinResponsePayload apply(List<CoinDTO> response) {
		String status;
		if (response.size() < 1)
			status = "failed";
		else
			status = "success";
			
		return CoinResponsePayload
				               .builder()
				               .data(response.stream().map(this::transformCoinDetails).toList())
				               .status(status)
				               .build();
	}

	private CoinDetails transformCoinDetails(CoinDTO response) {
		
		return CoinDetails.builder()
		                  .coinSymbol(response.getSymbol())
		                  .price(response.getPrice())
		                  .build();
	}

}
