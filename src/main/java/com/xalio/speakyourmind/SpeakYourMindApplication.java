package com.xalio.speakyourmind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpeakYourMindApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakYourMindApplication.class, args);
	}

}
