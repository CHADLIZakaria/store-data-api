package com.zchadli.storeData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoreDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreDataApplication.class, args);
	}

}
