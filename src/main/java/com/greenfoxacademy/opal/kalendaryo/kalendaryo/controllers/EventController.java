package com.greenfoxacademy.opal.kalendaryo.kalendaryo.controllers;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;

import static com.greenfoxacademy.opal.kalendaryo.kalendaryo.authorization.AuthorizeKal.getCalendarService;

@Controller("/kalendaryo")
public class EventController {


    DateTime startDateTime = new DateTime("2015-05-28T09:00:00-07:00");
    EventDateTime start = new EventDateTime()
        .setDateTime(startDateTime)
        .setTimeZone("America/Los_Angeles");

    DateTime endDateTime = new DateTime("2015-05-28T17:00:00-07:00");
    EventDateTime end = new EventDateTime()
        .setDateTime(endDateTime)
        .setTimeZone("America/Los_Angeles");

    @PostMapping("/insert")
    public void insertEvent() throws IOException {

        com.google.api.services.calendar.Calendar service =
            getCalendarService();
        Event event = service.events().insert("primary", new Event()
            .setDescription("New Event")
            .setSummary("This is my first event")
            .setStart(start)
            .setEnd(end))
            .execute();

    }


    @GetMapping("/update")
    public void updateEvent() throws IOException {
        com.google.api.services.calendar.Calendar service =
                getCalendarService();
        Event event = service.events().get("primary", "7nhdmehd85ogf46u0sdcpmfq7h").execute();
        event.setSummary("Troollolloo!!!");
        Event updatedEvent = service.events().update("primary", event.getId(), event).execute();
    }
}
