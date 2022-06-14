package com.assignment.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.assignment.app.authorization.CoinAutorizaton;
import com.assignment.app.model.CoinDTO;
import com.assignment.app.model.response.CoinResponsePayload;
import com.assignment.app.transformer.response.CoinResponsePayloadTransformer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoinService {
       
    private final CoinAutorizaton coinAuthorizatoin;
    
    private final CoinResponsePayloadTransformer coinResponsePayloadTransformer;
    
    
	public CoinResponsePayload search(String symbol) {
		if (!StringUtils.isEmpty(symbol))
		{	
			 var coinObj = coinAuthorizatoin.search(symbol);
			 return coinResponsePayloadTransformer.apply(
					 Objects.nonNull(coinObj)?List.of(coinObj):Collections.EMPTY_LIST);
		}
		else
		{
			return coinResponsePayloadTransformer.apply(coinAuthorizatoin.getAll());
		}	
	}


	public void save(CoinDTO data) {
		coinAuthorizatoin.save(data);
	}
}
