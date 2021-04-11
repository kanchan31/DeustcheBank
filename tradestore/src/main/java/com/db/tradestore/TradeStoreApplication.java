package com.db.tradestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.db.tradestore.*")
@EntityScan("com.db.tradestore.dto")
@EnableJpaRepositories("com.db.tradestore.repository")
public class TradeStoreApplication implements CommandLineRunner {

	@Autowired
	TradeStoreService tradeStoreService;
	@Override
	public void run(String[] args) throws Exception{
			tradeStoreService.processTradeStore();
	}

	public static void main(String[] args) {
		SpringApplication.run(TradeStoreApplication.class, args);

	}

}
