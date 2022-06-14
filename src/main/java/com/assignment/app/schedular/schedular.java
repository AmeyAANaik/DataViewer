package com.assignment.app.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.assignment.app.model.CoinDTO;
import com.assignment.app.model.CoinProxyResponse;
import com.assignment.app.proxy.CoinProxy;
import com.assignment.app.service.CoinService;
import com.assignment.app.utils.GeneralUtils;

import lombok.AllArgsConstructor;

@Component
public class schedular {

	@Autowired
	private  CoinProxy coinProxy;
    @Autowired
	private  CoinService coinService;

	@Value("${allowed.coins}")
	String allowedCoins;
    
	@Scheduled(fixedRate = 100000)
	void fetchCoinsData()
	{
		coinProxy.get().parallelStream()
		               .filter(obj -> allowedCoins.contains(obj.symbol()))
		               .forEach(this::checkFetchedPriceDataWithDBPriceData);
				       		
	}

	void checkFetchedPriceDataWithDBPriceData(CoinProxyResponse response)
	{
		var resObj = coinService.search(response.symbol());
        if (!resObj.getStatus().equals("success"))
        {
        	if (resObj.getData().size() < 1 || !resObj.getData().get(0).getPrice().equals(response.price()))
        	{
        		CoinDTO obj = new CoinDTO();
        		obj.setPrice(response.price());
        		obj.setSymbol(response.symbol());
        		coinService.save(obj);
        	}
        }
    }

}
