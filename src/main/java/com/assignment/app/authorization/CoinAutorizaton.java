package com.assignment.app.authorization;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.app.Integration.CoinIntegration;
import com.assignment.app.model.CoinDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoinAutorizaton {

	private final CoinIntegration coinIntegration;
	
	public CoinDTO search(String symbol) {
		return coinIntegration.search(symbol);
	}

	public List<CoinDTO> getAll() {
		return coinIntegration.getAll();
	}

	public void save(CoinDTO data) {
		coinIntegration.save(data);
	}
	
	

}
