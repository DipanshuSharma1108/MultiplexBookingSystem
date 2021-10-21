package com.cg.multiplexbookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication()
public class MultiplexBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplexBookingSystemApplication.class, args);
	}

}
