package com.biopark.challenge.dto;

import com.biopark.challenge.model.Comunication;
import com.biopark.challenge.util.Messages;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.biopark.challenge.util.Messages.CANT_BE_EMPTY;

public class ComunicationDTO implements Serializable {

    private UUID id;

    @NotEmpty(message = "Can't be empty!")
    private LocalDateTime dateTimeSend;

    private String reciver;

    private String message;

    private String status;

    public Comunication fromDTO() {
        return new Comunication(id, dateTimeSend, reciver, message, status);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeSend() {
        return dateTimeSend;
    }

    public void setDateTimeSend(LocalDateTime dateTimeSend) {
        this.dateTimeSend = dateTimeSend;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
