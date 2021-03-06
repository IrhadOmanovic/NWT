package com.projekat.Katalog.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.repository.KatalogRepository;

@Service
public class KatalogService {
	
	@Autowired
	private KatalogRepository katalogRepository;

	public Katalog findById(Long id) {
		return katalogRepository.findById(id).orElseThrow();
	}
	
	public Katalog createKatalog(String nazivProizvoda, String dodatneInformacije, int cijena, Date datumObjave, 
			Date datumZavrsetka, Long podkategorijaId, Long korisnikId, boolean zavrseno){
        return katalogRepository.save(new Katalog(nazivProizvoda, dodatneInformacije, cijena, datumObjave, datumZavrsetka, podkategorijaId, korisnikId, zavrseno));
    }
	
	public Katalog addNewKatalog(Katalog katalog) {
		return katalogRepository.save(new Katalog(katalog.getNazivProizvoda(), katalog.getDodatneInformacije(), katalog.getCijena(), katalog.getDatumObjave(), katalog.getDatumZavrsetka(), katalog.getPodkategorijaId(), katalog.getKorisnikId(), katalog.isZavrseno()));
	}
	
	public Katalog updateKatalog(Katalog katalog) {
		return katalogRepository.save(katalog);
	}
	
	public void deleteById(Long katalogId) {
        katalogRepository.deleteById(katalogId);
    }
	
}