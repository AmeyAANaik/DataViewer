package com.assignment.app.Integration;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.assignment.app.model.CoinDTO;
import com.assignment.app.repository.CoinJpaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoinIntegration {
	
	private final CoinJpaRepository coinRepository;
	
	@CacheEvict(cacheNames="coin" , key="#data.symbol")
	public void save(CoinDTO data)
	{
	    coinRepository.save(data);
	}

	@Cacheable(cacheNames="coin" , key="#symbol")
	public CoinDTO search(String symbol) {
		return coinRepository.findBySymbol(symbol)
				             .stream()
				             .findFirst()
				             .orElse(null);
	}

	public List<CoinDTO> getAll() {
		
		return coinRepository.getAll();
	}


	
}
