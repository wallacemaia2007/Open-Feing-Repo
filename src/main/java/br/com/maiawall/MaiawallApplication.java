package br.com.maiawall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MaiawallApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaiawallApplication.class, args);
	}

}
