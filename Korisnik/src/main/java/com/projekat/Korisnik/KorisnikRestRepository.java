package com.projekat.Korisnik;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "korisnici", path = "korisnici")
public interface KorisnikRestRepository extends PagingAndSortingRepository<Korisnik, Long> {

  List<Korisnik> findByLastName(@Param("lastName") String name);
  List<Korisnik> findByFirstName(@Param("firstName") String name);

}


