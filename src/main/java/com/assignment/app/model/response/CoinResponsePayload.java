package com.assignment.app.model.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinResponsePayload {
	
	@Schema(name="status" , description="status of the request" , example="success/failed")
	String status;
	
	@Schema(name="data" , description = "List of the symbol" )
	List<CoinDetails> data;

}
