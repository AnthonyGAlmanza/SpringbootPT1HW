package com.tts.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tts.playground.domain.VideoGame;
import com.tts.playground.repository.GameNameRepository;

@SpringBootApplication
public class PlaygroundApplication {

	private static final Logger log = LoggerFactory.getLogger(PlaygroundApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(GameNameRepository repository) {
		return (args) -> {
			// save a couple of games
			repository.save(new VideoGame("Legend of Zelda: Breath of the Wild", "Action/Adventure", "Nintendo Switch"));
			repository.save(new VideoGame("Diablo II", "Action RPG", "PC"));
			repository.save(new VideoGame("Minecraft", "Sandbox/Creative", "Playstation 4"));
			repository.save(new VideoGame("Final Fantasy 14", "MMORPG", "PC"));
			repository.save(new VideoGame("Super Metroid", "Action/Adventure", "Super Nintendo"));
			repository.save(new VideoGame("Call of Duty: Warzone", "First person shooter", "Playstation 4"));

			// read all games
			log.info("Game found with findAll():");
			log.info("-------------------------------");
			for (VideoGame title : repository.findAll()) {
				log.info(title.toString());
			}
			log.info("");

			// read a game by ID
			repository.findById(1L).ifPresent(title -> {
				log.info("Game found with findById(1L):");
				log.info("--------------------------------");
				log.info(title.toString());
				log.info("");
			});

			// read game by last name
			log.info("Game found with findByTitle('Super Metroid'):");
			log.info("--------------------------------------------");
			repository.findByTitle("Super Metroid").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");
		};
	}

}
