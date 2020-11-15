package com.biopark.challenge.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "comunication")
public class Comunication implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotEmpty(message = "Can't be empty!")
    private LocalDateTime dateTimeSend;

    private String reciver;

    private String message;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Comunication() {
    }

    public Comunication(UUID id, LocalDateTime dateTimeSend, String reciver, String message,
                        String status) {
        this.id = id;
        this.dateTimeSend = dateTimeSend;
        this.reciver = reciver;
        this.message = message;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeSend() {
        return dateTimeSend;
    }

    public void setDateTimeSend(final LocalDateTime dateTimeSend) {
        this.dateTimeSend = dateTimeSend;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(final String reciver) {
        this.reciver = reciver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comunication that = (Comunication) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
