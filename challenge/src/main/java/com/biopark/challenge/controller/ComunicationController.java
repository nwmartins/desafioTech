package com.biopark.challenge.controller;

import com.biopark.challenge.model.Comunication;
import com.biopark.challenge.model.Consumer;
import com.biopark.challenge.service.ComunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "api") //Sempre depois da porta /api + restante da URL
public class ComunicationController {

    //Controlador REST, irá acessar a camada de Serviços = Services;

    @Autowired
    private ComunicationService comunicationService;

    @RequestMapping(value = "comunications", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(comunicationService.findAll());
    }

    @RequestMapping(value = "comunication/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(comunicationService.findById(id));
    }

    @RequestMapping(value = "comunication", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Comunication comunication) {
        comunication = comunicationService.save(comunication);
        //Obtem a nova URI do novo Objeto para retornar no Header
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(comunication.getId()).toUri();
        return ResponseEntity.created(uri).build(); //Ja retorna 201
    }

    @RequestMapping(value = "comunication/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody Comunication comunication){
        comunication.setId(id);
        comunicationService.update(comunication);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "comunication/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        comunicationService.delete(id);
        return ResponseEntity.noContent().build();
    }




}

