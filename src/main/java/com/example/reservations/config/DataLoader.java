package com.example.reservations.config;

import com.example.reservations.entity.Agency;
import com.example.reservations.entity.Artist;
import com.example.reservations.repository.AgencyRepository;
import com.example.reservations.repository.ArtistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AgencyRepository agencyRepository;
    private final ArtistRepository artistRepository;

    public DataLoader(AgencyRepository agencyRepository, ArtistRepository artistRepository) {
        this.agencyRepository = agencyRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        artistRepository.deleteAll();
        agencyRepository.deleteAll();


        Agency actingAssociation = new Agency("Acting Association");
        Agency newAgency = new Agency("New Agency");

        agencyRepository.save(actingAssociation);
        agencyRepository.save(newAgency);


        Artist bobSull = new Artist("Bob", "Sull", actingAssociation);
        Artist lydiaSmith = new Artist("Lydia", "Smith", actingAssociation);
        Artist fredDurand = new Artist("Fred", "Durand", newAgency);

        artistRepository.save(bobSull);
        artistRepository.save(lydiaSmith);
        artistRepository.save(fredDurand);

        System.out.println("Test data loaded successfully");
    }
}