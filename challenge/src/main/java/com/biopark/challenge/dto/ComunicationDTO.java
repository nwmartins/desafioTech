package com.biopark.challenge.dto;

import com.biopark.challenge.model.Comunication;
import com.biopark.challenge.util.Status;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Validated
public class ComunicationDTO implements Serializable {

    private UUID id;

    @NotNull
    private LocalDateTime dateTimeSend;

    @NotNull
    private String reciver;

    @NotNull
    private String message;

    @NotNull
    private Status status;

    public ComunicationDTO() {
    }

    public ComunicationDTO(Comunication comunication) {
        id = comunication.getId();
        dateTimeSend = comunication.getDateTimeSend();
        reciver = comunication.getReciver();
        message = comunication.getMessage();
        status = comunication.getStatus();
    }

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
