package com.byvyd.api.controller.mapper;

import com.byvyd.api.controller.dto.EventCreateDTO;
import com.byvyd.api.controller.dto.EventDTO;
import com.byvyd.api.model.Event;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public EventDTO toEventDTO(Event event){
        return MODEL_MAPPER.map(event, EventDTO.class);
    }

    public List<EventDTO> toEventDTOList(List<Event> eventList) {
        return eventList.stream().map(this::toEventDTO).collect(Collectors.toList());
    }

    public Event toEvent(EventDTO dto) {
        return MODEL_MAPPER.map(dto, Event.class);
    }

    public Event toEventCreate(EventCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Event.class);
    }
}