package com.byvyd.api.model;

import javax.persistence.*;

@Entity
@Table(name = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idVideo;
    @Column
    private Boolean aprovado;
    @Column
    private Long idEvento;
    @Column
    private Long idSender;

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

}
