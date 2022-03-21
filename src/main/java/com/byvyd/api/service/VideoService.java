package com.byvyd.api.service;

import com.byvyd.api.exception.VideoNotFoundException;
import com.byvyd.api.model.Video;
import com.byvyd.api.repository.VideoRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video>findAll(){
        return videoRepository.findAll();
    }

    public Video findById(String idVideo) {
        return videoRepository.findById(Long.valueOf(idVideo)).orElseThrow(()->
                new VideoNotFoundException(idVideo));
    }

    public Video create(Video videoCreate) {
        videoCreate.setAprovado(false);
        videoRepository.save(videoCreate);
        return videoCreate;
    }

    public void delete(String idVideo) {
        findById(idVideo);
        videoRepository.deleteById(Long.valueOf(idVideo));
    }

    public Video update(String idVideo, Video videoCreate) {
        Video Video = findById(idVideo);
        Video.setAprovado(videoCreate.getAprovado());
        Video.setIdSender(videoCreate.getIdSender());
        Video.setIdEvento(videoCreate.getIdEvento());
        videoRepository.save(Video);
        return Video;
    }
}
