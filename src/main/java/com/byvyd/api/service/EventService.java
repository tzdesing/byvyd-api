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

    private static Map<Integer, Event> eventMap = new HashMap();

    private static Date dateExemplo(){
        Calendar c = Calendar.getInstance();
        c.set(2022, 01 , 23);
        Date dataAux = c.getTime();
        return(dataAux);
    }

    static {
        Random geradorId = new Random(19700620);
        var id= geradorId.nextInt(100000);
        var id1= geradorId.nextInt(100000);
        var idO= geradorId.nextInt(100000);
        var idH= geradorId.nextInt(100000);
        var idO1= geradorId.nextInt(100000);
        var idH1= geradorId.nextInt(100000);

        Event event = new Event(id, "Niver Rogerio", 1, idO, idH, dateExemplo());
        Event event1 = new Event(id1, "Niver Monica", 1, idO1, idH1, dateExemplo());
        eventMap.put(1, event);
        eventMap.put(2, event1);
    }

    public List<Event>findAll(){
        return eventMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Event findById(Integer id) {
        Event event = eventMap.get(id);
        if (event == null){
            throw new EventNotFoundException(id);
        }
        return eventMap.get(id);
    }

    public Event create(Event eventCreate) {
        Integer uuid = Integer.valueOf(getUUID());
        eventCreate.setId(uuid);
        eventCreate.setEntryDate(LocalDateTime.now());
        eventMap.put(uuid, eventCreate);

        return eventCreate;
    }

    public void delete(Integer id) {
        findById(id);
        eventMap.remove(id);
    }

    public Event update(Integer id, Event eventCreate) {
        Event Event = findById(id);
        Event.setTitulo(eventCreate.getTitulo());
        Event.setDataNiver(eventCreate.getDataNiver());
        eventMap.replace(id, Event);
        return Event;
    }
}
