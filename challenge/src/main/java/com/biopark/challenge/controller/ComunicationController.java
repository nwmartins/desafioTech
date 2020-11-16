package com.biopark.challenge.controller;

import com.biopark.challenge.dto.ComunicationDTO;
import com.biopark.challenge.model.Comunication;
import com.biopark.challenge.service.ComunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api")
public class ComunicationController {

    //Controlador REST, irá acessar a camada de Serviços;

    @Autowired
    private ComunicationService comunicationService;

    @RequestMapping(value = "comunications", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<Comunication> comunications = comunicationService.findAll();
        List<ComunicationDTO> comunicationDTO = comunications.stream().map(ComunicationDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(comunicationDTO);
    }

    @RequestMapping(value = "comunication/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable UUID id){
        ComunicationDTO comunicationDTO = new ComunicationDTO(comunicationService.findById(id));
        return ResponseEntity.ok().body(comunicationDTO);
    }

    @RequestMapping(value = "comunication", method = RequestMethod.POST)
    public ResponseEntity<Comunication> save(@Valid @RequestBody ComunicationDTO dto) {
        Comunication comunication = comunicationService.save(dto.fromDTO());
        return new ResponseEntity<>(comunication, HttpStatus.CREATED);
    }

    @RequestMapping(value = "comunication/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable UUID id, @Valid @RequestBody ComunicationDTO comunicationDTO){
        comunicationDTO.setId(id);
        comunicationService.update(comunicationDTO.fromDTO());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "comunication/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        comunicationService.delete(id);
        return ResponseEntity.noContent().build();
    }




}

