package com.byvyd.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class Event {

    private Long idEvento;
    private String titulo;
    private Integer status;
    private Long idOrganizador;
    private Long idHomenageado;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime entryDate;
    private Date dataNiver;

    public Event(Long idEvento, String titulo, Integer status, Long idOrganizador, Long idHomenageado, Date dataNiver) {
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.status = status;
        this.idOrganizador = idOrganizador;
        this.idHomenageado = idHomenageado;
        this.dataNiver = dataNiver;
    }

    public Event(){
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
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

    public Long getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(Long idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public Long getIdHomenageado() {
        return idHomenageado;
    }

    public void setIdHomenageado(Long idHomenageado) {
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
