package com.byvyd.api.service;

import com.byvyd.api.exception.EventNotFoundException;
import com.byvyd.api.model.Event;
import com.byvyd.api.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Event>findAll(){
        return eventRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Event findById(String idEvento) {
        return eventRepository.findById(Long.valueOf(idEvento)).orElseThrow(()->
                new EventNotFoundException(idEvento));
    }

    @Transactional
    public Event create(Event eventCreate) {
        eventCreate.setStatus(1);
        eventCreate.setEntryDate(LocalDateTime.now());
        eventRepository.save(eventCreate);
        return eventCreate;
    }

    @Transactional
    public void delete(String idEvento) {
        findById(idEvento);
        eventRepository.deleteById(Long.valueOf(idEvento));
    }

    @Transactional
    public Event update(String idEvento, Event eventCreate) {
        Event event = findById(idEvento);
        event.setTitulo(eventCreate.getTitulo());
        event.setDataNiver(eventCreate.getDataNiver());
        event.setStatus(eventCreate.getStatus());
        event.setIdHomenageado(eventCreate.getIdHomenageado());
        event.setIdOrganizador(eventCreate.getIdOrganizador());
        eventRepository.save(event);
        return event;
    }
}
