package com.assignment.app.utils;

import org.springframework.beans.factory.annotation.Value;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GeneralUtils {
	
	@Value("${allowed.coins}")
	String allowedCoins;
	
	public static String fetchAllowedCoins()
	{
		return allowedCoins;
	}

}
