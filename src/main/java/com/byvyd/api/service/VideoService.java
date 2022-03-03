package com.byvyd.api.service;

import com.byvyd.api.exception.VideoNotFoundException;
import com.byvyd.api.model.Event;
import com.byvyd.api.model.Video;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VideoService {

    private static Map<String, Video> videoMap = new HashMap();

    private static Date dateExemplo(){
        Calendar c = Calendar.getInstance();
        c.set(2022, 01 , 23);
        Date dataAux = c.getTime();
        return(dataAux);
    }

    static {
        Random geradorId = new Random();
        var id= geradorId.nextInt(1000000);
        var id1= geradorId.nextInt(1000000);
        var idE= geradorId.nextInt(1000000);
        var idE1= geradorId.nextInt(1000000);
        var idS= geradorId.nextInt(1000000);
        var idS1= geradorId.nextInt(1000000);

        Video video = new Video((long)id, true, (long)idE, (long)idS);
        Video video1 = new Video((long)id1, false, (long)idE1, (long)idS1);
        videoMap.put(String.valueOf(id), video);
        videoMap.put(String.valueOf(id1), video1);
    }

    public List<Video>findAll(){
        return videoMap.values().stream().collect(Collectors.toList());
    }

    /*private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }*/

    public Video findById(String idVideo) {
        Video video = videoMap.get(idVideo);
        if (video == null){
            throw new VideoNotFoundException(idVideo);
        }
        return videoMap.get(idVideo);
    }

    public Video create(Video videoCreate) {
        Random geradorId = new Random();
        var randomId = geradorId.nextInt(1000000);
        videoCreate.setIdVideo((long) randomId);
        videoCreate.setAprovado(false);
        videoCreate.setEntryDate(LocalDateTime.now());
        videoMap.put(String.valueOf(randomId), videoCreate);
        return videoCreate;
    }

    public void delete(String idVideo) {
        findById(idVideo);
        videoMap.remove(idVideo);
    }

    public Video update(String idVideo, Video videoCreate) {
        Video Video = findById(idVideo);
        Video.setAprovado(videoCreate.getAprovado());
        Video.setIdSender(videoCreate.getIdSender());
        Video.setIdEvento(videoCreate.getIdEvento());
        videoMap.replace(idVideo, Video);
        return Video;
    }
}
