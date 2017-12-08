package com.greenfoxacademy.opal.kalendaryo.kalendaryo.controllers;
import com.google.api.services.calendar.Calendar.Events.Watch;
import com.google.api.services.calendar.model.Channel;
import com.google.api.services.calendar.model.Event;
import com.greenfoxacademy.opal.kalendaryo.kalendaryo.model.EventChange;
import com.greenfoxacademy.opal.kalendaryo.kalendaryo.model.EventResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.greenfoxacademy.opal.kalendaryo.kalendaryo.authorization.AuthorizeKal.getCalendarService;

@Controller("/kalendaryo")
public class EventController {

    @GetMapping("/update")
    public void updateEvent() throws IOException {
        com.google.api.services.calendar.Calendar service =
                getCalendarService();
        Event event = service.events().get("primary", "7nhdmehd85ogf46u0sdcpmfq7h").execute();
        event.setSummary("Troollolloo!!!");
        Event updatedEvent = service.events().update("primary", event.getId(), event).execute();
    }

    @GetMapping(value = "/notification")
    public Watch eventNotification() throws IOException {
        com.google.api.services.calendar.Calendar service =
            getCalendarService();
        Channel channel = new Channel();
        Watch eventWatch = service.events().watch("primary", channel);
        return eventWatch;
    }


}
