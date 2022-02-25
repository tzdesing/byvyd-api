package com.byvyd.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EventCreateDTO {

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
}
