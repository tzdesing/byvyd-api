package com.byvyd.api.service;

import com.byvyd.api.exception.EventNotFoundException;
import com.byvyd.api.model.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {

    private static Map<String, Event> eventMap = new HashMap();

    static {
        var id= getUUID();
        var id1= getUUID();
        Event event = new Event(id, "DMS-1111", "SC", "CELTA", "PRETO");
        Event event1 = new Event(id1, "WAS-1234", "SP", "VW GOL", "VERMELHO");
        eventMap.put(id, event);
        eventMap.put(id1, event1);
    }

    public List<Event>findAll(){
        return eventMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Event findById(String id) {
        Event event = eventMap.get(id);
        if (event == null){
            throw new EventNotFoundException(id);
        }
        return eventMap.get(id);
    }

    public Event create(Event eventCreate) {
        String uuid = getUUID();
        eventCreate.setId(uuid);
        eventCreate.setEntryDate(LocalDateTime.now());
        eventMap.put(uuid, eventCreate);

        return eventCreate;
    }

    public void delete(String id) {
        findById(id);
        eventMap.remove(id);
    }

    public Event update(String id, Event eventCreate) {
        Event Event = findById(id);
        Event.setColor(eventCreate.getColor());
        eventMap.replace(id, Event);
        return Event;
    }
}
