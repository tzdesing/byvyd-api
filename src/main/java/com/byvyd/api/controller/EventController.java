package com.byvyd.api.controller;

import com.byvyd.api.controller.dto.EventCreateDTO;
import com.byvyd.api.controller.dto.EventDTO;
import com.byvyd.api.controller.mapper.EventMapper;
import com.byvyd.api.model.Event;

import com.byvyd.api.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@Api(tags = "Event Controller")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @GetMapping("/findAll")
    @ApiOperation("Find all")
    public ResponseEntity<List<EventDTO>> findAll(){
        List<Event> eventList = eventService.findAll();
        List<EventDTO> result = eventMapper.toEventDTOList(eventList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findById/{idEvento}")
    @ApiOperation("Find By Id")
    public ResponseEntity<EventDTO> findById(@PathVariable String idEvento){
        Event event = eventService.findById(idEvento);
        EventDTO result = eventMapper.toEventDTO(event);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{idEvento}")
    @ApiOperation("Delete")
    public ResponseEntity delete(@PathVariable String idEvento){
        eventService.delete(idEvento);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create")
    @ApiOperation("Create")
    public ResponseEntity<EventDTO> create(@RequestBody EventDTO dto){
        var eventCreate = eventMapper.toEvent(dto);
        var event = eventService.create(eventCreate);
        var result = eventMapper.toEventDTO(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/update/{idEvento}")
    @ApiOperation("Update")
    public ResponseEntity<EventDTO> update(@PathVariable String idEvento, @RequestBody EventDTO dto){
        var eventCreate = eventMapper.toEvent(dto);
        var event = eventService.update(idEvento, eventCreate);
        var result = eventMapper.toEventDTO(event);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
