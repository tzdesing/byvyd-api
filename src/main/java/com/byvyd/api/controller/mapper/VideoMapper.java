package com.byvyd.api.controller.mapper;

import com.byvyd.api.controller.dto.VideoCreateDTO;
import com.byvyd.api.controller.dto.VideoDTO;
import com.byvyd.api.model.Video;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public VideoDTO toVideoDTO(Video video){
        return MODEL_MAPPER.map(video, VideoDTO.class);
    }

    public List<VideoDTO> toVideoDTOList(List<Video> videoList) {
        return videoList.stream().map(this::toVideoDTO).collect(Collectors.toList());
    }

    public Video toVideo(VideoDTO dto) {
        return MODEL_MAPPER.map(dto, Video.class);
    }

    public Video toVideoCreate(VideoCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Video.class);
    }
}
