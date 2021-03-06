package com.projekat.Katalog;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.projekat.Katalog.KatalogApplication;
import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.repository.KatalogRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class KatalogApplication {

	private static final Logger log = LoggerFactory.getLogger(KatalogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KatalogApplication.class, args);
	}
	
	@RestController
	class ServiceInstanceRestController {

		@Autowired
		private DiscoveryClient discoveryClient;

		@RequestMapping("/service-instances/{applicationName}")
		public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
			return this.discoveryClient.getInstances(applicationName);
		}
	}
	
	@Bean
	public CommandLineRunner demo(KatalogRepository repository) {
		return (args) -> {
	      // save a few catalogs
	      repository.save(new Katalog("mobitel", "dodatneInformacije", 250, null, null, 1L, 2L, true));
	      repository.save(new Katalog("auto", "dodatneInformacije", 5500, null, null, 3L, 4L, true));
	      repository.save(new Katalog("avion", "dodatneInformacije", 1000000, null, null, 5L, 6L, true));
	      repository.save(new Katalog("kamion", "dodatneInformacije", 20000, null, null, 7L, 8L, true));
	      repository.save(new Katalog("jahta", "dodatneInformacije", 1000000, null, null, 9L, 10L, true));
	      repository.save(new Katalog("voz", "dodatneInformacije", 50000, null, null, 11L, 12L, true));

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
