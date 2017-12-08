package com.greenfoxacademy.opal.kalendaryo.kalendaryo.controllers;

import static com.greenfoxacademy.opal.kalendaryo.kalendaryo.authorization.AuthorizeKal.getCalendarService;
import com.google.api.services.calendar.Calendar.Events.Watch;
import com.google.api.services.calendar.model.Channel;
import com.greenfoxacademy.opal.kalendaryo.kalendaryo.model.EventChange;
import com.greenfoxacademy.opal.kalendaryo.kalendaryo.model.EventResponse;
import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class NotificationController {

    @PostMapping("/noti")
    public EventResponse eventWatch(@RequestBody EventChange eventChange) throws IOException {
       // com.google.api.services.calendar.Calendar service = getCalendarService();
        Channel channel = new Channel();
       /* Watch eventWatch = service.events().watch(eventChange.getId(), channel);
        eventWatch.execute();*/
        return new EventResponse("api#channel", channel.getId(), eventChange.getId(), "https://www.googleapi.com/calendar/v3/calendars/\" + calendarId + \"/events" );
    }

    /*@GetMapping(value = "/notification")
    public void eventNotification() throws IOException {
        com.google.api.services.calendar.Calendar service =
            getCalendarService();
        Channel channel = new Channel();
        Watch eventWatch = service.events().watch("primary", channel);
        System.out.println("hello");
    }*/

   /* @PostMapping(value = "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/watch")
    public EventResponse watchEvents (@PathVariable("calendarId") String calendarId,
        @RequestBody EventChange eventChange) {

        return new EventResponse("api#channel", "channelid", eventChange.getId(), "https://www.googleapis.com/calendar/v3/calendars/" + calendarId + "/events");
    }*/


}
