package com.biopark.challenge.service;

import com.biopark.challenge.model.Comunication;
import com.biopark.challenge.repository.ComunicationRepository;
import com.biopark.challenge.service.exception.DataIntegrityException;
import com.biopark.challenge.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComunicationService {

    //Objeto de Serviço, acessa a camada de Acesso a Dados = Repository

    @Autowired //Instancia pelo Spring;
            ComunicationRepository comunicationRepository;

    public List<Comunication> findAll() {
        List<Comunication> comunications = comunicationRepository.findAll();
        if (comunications.isEmpty())
            throw new ObjectNotFoundException("Comunications not found!");
        return comunications;
    }

    public Comunication findById(UUID id) {
        Optional<Comunication> c = comunicationRepository.findById(id);
        //orElseThrow = Funcao q instancia uma exception, Lambda sem argumentos que retona minha classe
        return c.orElseThrow(() -> new ObjectNotFoundException(
                "Comunication not found! Id: " + id));
    }

    public Comunication save(Comunication comunication) {
        comunication.setId(null); //Pra ter certeza que o registro e novo
        comunication.setUpdatedAt(LocalDateTime.now());
        comunication.setCreatedAt(LocalDateTime.now());
        return comunicationRepository.save(comunication);
    }

    public Comunication update(Comunication comunication) {
        findById(comunication.getId()); //Caso o objeto n existir, ja ira retornar exception
        comunication.setUpdatedAt(LocalDateTime.now());
        return comunicationRepository.save(comunication);
    }

    public void delete(UUID id) {
        findById(id); //Caso o objeto n existir, ja ira retornar exception
        try {
            comunicationRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Can't Delete!");
        }
    }

}