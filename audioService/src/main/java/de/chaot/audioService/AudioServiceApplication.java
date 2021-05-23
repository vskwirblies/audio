package de.chaot.audioService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("de.chaot.audioDomain")
public class AudioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioServiceApplication.class, args);
	}

}
