package com.biopark.challenge.repository;

import com.biopark.challenge.model.Comunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComunicationRepository extends JpaRepository<Comunication, UUID>{
    //Deixo vazio, pois herda de JPA
}

