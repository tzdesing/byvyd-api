package com.byvyd.api.controller.dto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EventCreateDTO {

    private Long idOrganizador;
    private Long idHomenageado;
    private String titulo;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNiver;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataNiver() {
        return dataNiver;
    }

    public void setDataNiver(Date dataNiver) {
        this.dataNiver = dataNiver;
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

}




