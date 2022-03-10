package com.byvyd.api.service;

import com.byvyd.api.exception.EventNotFoundException;
import com.byvyd.api.model.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import java.util.Calendar;
import java.util.Date;

@Service
public class EventService {

    private static Map<String, Event> eventMap = new HashMap();

/*
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
        var idO= geradorId.nextInt(1000000);
        var idH= geradorId.nextInt(1000000);
        var idO1= geradorId.nextInt(1000000);
        var idH1= geradorId.nextInt(1000000);

        Event event = new Event((long)id, "Niver Rogerio", 1, (long)idO, (long)idH, dateExemplo());
        Event event1 = new Event((long)id1, "Niver Monica", 1, (long)idO1, (long)idH1, dateExemplo());
        eventMap.put(String.valueOf(id), event);
        eventMap.put(String.valueOf(id1), event1);
    }*/

    public List<Event>findAll(){
        return eventMap.values().stream().collect(Collectors.toList());
    }

    //private static String getUUID() {
        //return UUID.randomUUID().toString().replace("-","");
    //}

    public Event findById(String idEvento) {
        Event event = eventMap.get(idEvento);
        if (event == null){
            throw new EventNotFoundException(Long.valueOf(idEvento));
        }
        return eventMap.get(idEvento);
    }

    public Event create(Event eventCreate) {
        /*Random geradorId = new Random();
        var randomId = geradorId.nextInt(1000000);*/
        eventCreate.setIdEvento(eventCreate.getIdEvento());
        eventCreate.setStatus(1);
        eventCreate.setEntryDate(LocalDateTime.now());
        eventMap.put(String.valueOf(eventCreate.getIdEvento()), eventCreate);
        return eventCreate;
    }

    public void delete(String idEvento) {
        findById(idEvento);
        eventMap.remove(idEvento);
    }

    public Event update(String idEvento, Event eventCreate) {
        Event event = findById(idEvento);
        event.setTitulo(eventCreate.getTitulo());
        event.setDataNiver(eventCreate.getDataNiver());
        event.setStatus(eventCreate.getStatus());
        event.setIdHomenageado(eventCreate.getIdHomenageado());
        event.setIdOrganizador(eventCreate.getIdOrganizador());
        eventMap.replace(idEvento, event);
        return event;
    }
}
