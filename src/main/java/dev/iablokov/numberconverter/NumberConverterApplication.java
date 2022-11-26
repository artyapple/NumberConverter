package dev.iablokov.numberconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NumberConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberConverterApplication.class, args);
	}

}
