package br.com.letscode.java.stringapiletscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StringApiLetscodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringApiLetscodeApplication.class, args);
	}

}
