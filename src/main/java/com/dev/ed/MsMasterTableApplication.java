package com.dev.ed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients("com.dev.ed")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class MsMasterTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMasterTableApplication.class, args);
	}

}
