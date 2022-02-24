package com.byvyd.api.controller;

import com.byvyd.api.controller.dto.VideoCreateDTO;
import com.byvyd.api.controller.dto.VideoDTO;
import com.byvyd.api.controller.mapper.VideoMapper;
import com.byvyd.api.model.Video;

import com.byvyd.api.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
@Api(tags = "Video Controller")
public class VideoController {

    private final VideoService videoService;
    private final VideoMapper videoMapper;

    public VideoController(VideoService videoService, VideoMapper videoMapper) {
        this.videoService = videoService;
        this.videoMapper = videoMapper;
    }

    @GetMapping("/findAll")
    @ApiOperation("Find all")
    public ResponseEntity<List<VideoDTO>> findAll(){
        List<Video> videoList = videoService.findAll();
        List<VideoDTO> result = videoMapper.toVideoDTOList(videoList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation("Find By Id")
    public ResponseEntity<VideoDTO> findById(@PathVariable String id){
        Video video = videoService.findById(id);
        VideoDTO result = videoMapper.toVideoDTO(video);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete")
    public ResponseEntity delete(@PathVariable String id){
        videoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create")
    @ApiOperation("Create")
    public ResponseEntity<VideoDTO> create(@RequestBody VideoCreateDTO dto){
        var videoCreate = videoMapper.toVideoCreate(dto);
        var video = videoService.create(videoCreate);
        var result = videoMapper.toVideoDTO(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Update")
    public ResponseEntity<VideoDTO> update(@PathVariable String id, @RequestBody VideoCreateDTO dto){
        var videoCreate = videoMapper.toVideoCreate(dto);
        var video = videoService.update(id, videoCreate);
        var result = videoMapper.toVideoDTO(video);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
