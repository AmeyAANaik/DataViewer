package com.assignment.app.proxy;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assignment.app.model.CoinProxyResponse;

@FeignClient(name="CoinProxy" , url="${coinbase.host.server.url}")
public interface CoinProxy {

	@GetMapping("v3/ticker/price")
	List<CoinProxyResponse> get();
}
