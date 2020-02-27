package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private ExchangeValueRepository exchangevalueRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from,@PathVariable String to) {
		 
				
				ExchangeValue exchangevalue=exchangevalueRepository.findByFromAndTo(from, to);
				
				exchangevalue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
				return exchangevalue;
	}

}
