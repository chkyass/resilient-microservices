package chkyass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RatingsDataServiceApplication {
	@Autowired
	static RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RatingsDataServiceApplication.class, args);
	}

}

