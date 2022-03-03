package com.byvyd.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class VideoNotFoundException extends RuntimeException {

    public VideoNotFoundException(String idVideo) {
        super("Video not found with Id: " + idVideo);
    }
}
