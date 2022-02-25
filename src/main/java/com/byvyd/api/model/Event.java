package com.byvyd.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class Event {

    private Integer id;
    private String titulo;
    private Integer status;
    private Integer idOrganizador;
    private Integer idHomenageado;
    private LocalDateTime entryDate;
    private Date dataNiver;

    public Event(Integer id, String titulo, Integer status, Integer idOrganizador, Integer idHomenageado, Date dataNiver) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.idOrganizador = idOrganizador;
        this.idHomenageado = idHomenageado;
        this.dataNiver = dataNiver;
    }

    public Event(){
    }

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
