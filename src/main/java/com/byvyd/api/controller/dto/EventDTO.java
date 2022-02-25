package com.byvyd.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.models.properties.DateTimeProperty;

import java.util.Date;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDTO {

    private Integer id;
    private String titulo;
    private Integer status;
    private Integer idOrganizador;
    private Integer idHomenageado;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime entryDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNiver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(Integer idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public Integer getIdHomenageado() {
        return idHomenageado;
    }

    public void setIdHomenageado(Integer idHomenageado) {
        this.idHomenageado = idHomenageado;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public Date getDataNiver() {
        return dataNiver;
    }

    public void setDataNiver(Date dataNiver) {
        this.dataNiver = dataNiver;
    }
}
