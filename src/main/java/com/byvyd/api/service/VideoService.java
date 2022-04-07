package com.byvyd.api.service;

import com.byvyd.api.exception.VideoNotFoundException;
import com.byvyd.api.model.Video;
import com.byvyd.api.repository.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Video>findAll(){
        return videoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Video findById(String idVideo) {
        return videoRepository.findById(Long.valueOf(idVideo)).orElseThrow(()->
                new VideoNotFoundException(idVideo));
    }

    @Transactional
    public Video create(Video videoCreate) {
        videoCreate.setAprovado(false);
        videoRepository.save(videoCreate);
        return videoCreate;
    }

    @Transactional
    public void delete(String idVideo) {
        findById(idVideo);
        videoRepository.deleteById(Long.valueOf(idVideo));
    }

    @Transactional
    public Video update(String idVideo, Video videoCreate) {
        Video Video = findById(idVideo);
        Video.setAprovado(videoCreate.getAprovado());
        Video.setIdSender(videoCreate.getIdSender());
        Video.setIdEvento(videoCreate.getIdEvento());
        videoRepository.save(Video);
        return Video;
    }
}
