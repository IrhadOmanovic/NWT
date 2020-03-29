package com.projekat.Katalog;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projekat.Katalog.KatalogApplication;
import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.repository.KatalogRepository;

@SpringBootApplication
public class KatalogApplication {

	private static final Logger log = LoggerFactory.getLogger(KatalogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KatalogApplication.class, args);
	}
	Date datum1 = new Date();
	@Bean
	public CommandLineRunner demo(KatalogRepository repository) {
		return (args) -> {
	      // save a few catalogs
	      repository.save(new Katalog("mobitel", "dodatneInformacije", 250, null, null, 1L, 2L, true));
	      repository.save(new Katalog("auto", "dodatneInformacije", 250, null, null, 1L, 2L, true));
	      repository.save(new Katalog("avion", "dodatneInformacije", 250, null, null, 1L, 2L, true));
	      repository.save(new Katalog("kamion", "dodatneInformacije", 250, null, null, 1L, 2L, true));
	      repository.save(new Katalog("jahta", "dodatneInformacije", 250, null, null, 1L, 2L, true));
	      repository.save(new Katalog("voz", "dodatneInformacije", 250, null, null, 1L, 2L, true));

	      // fetch all catalogs
	      log.info("Katalogs found with findAll():");
	      log.info("-------------------------------");
	      for (Katalog catalog : repository.findAll()) {
	        log.info(catalog.toString());
	      }
	      log.info("");

	      // fetch an individual catalog by ID
	      log.info("Katalog found with findById(1L):");
	      log.info("--------------------------------");
	      Katalog catalog = repository.findById(1L);
	      log.info(catalog.toString());
	      log.info("");
	    };
	  }
}
