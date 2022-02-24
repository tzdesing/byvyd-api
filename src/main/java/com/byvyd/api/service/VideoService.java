package com.byvyd.api.service;

import com.byvyd.api.exception.VideoNotFoundException;
import com.byvyd.api.model.Video;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VideoService {

    private static Map<String, Video> videoMap = new HashMap();

    static {
        var id= getUUID();
        var id1= getUUID();
        Video video = new Video(id, "DMS-1111", "SC", "CELTA", "PRETO");
        Video video1 = new Video(id1, "WAS-1234", "SP", "VW GOL", "VERMELHO");
        videoMap.put(id, video);
        videoMap.put(id1, video1);
    }

    public List<Video>findAll(){
        return videoMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Video findById(String id) {
        Video video = videoMap.get(id);
        if (video == null){
            throw new VideoNotFoundException(id);
        }
        return videoMap.get(id);
    }

    public Video create(Video videoCreate) {
        String uuid = getUUID();
        videoCreate.setId(uuid);
        videoCreate.setEntryDate(LocalDateTime.now());
        videoMap.put(uuid, videoCreate);

        return videoCreate;
    }

    public void delete(String id) {
        findById(id);
        videoMap.remove(id);
    }

    public Video update(String id, Video videoCreate) {
        Video Video = findById(id);
        Video.setColor(videoCreate.getColor());
        videoMap.replace(id, Video);
        return Video;
    }
}
