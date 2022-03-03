package com.byvyd.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Video {

    private Long idVideo;
    private Boolean aprovado;
    private Long idEvento;
    private Long idSender;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime entryDate;

    public Video(Long idVideo, Boolean aprovado, Long idEvento, Long idSender) {
        this.idVideo = idVideo;
        this.aprovado = aprovado;
        this.idEvento = idEvento;
        this.idSender = idSender;
    }

    public Video(){
    }

    public Long getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Long idVideo) {
        this.idVideo = idVideo;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }
}
