package com.greenfoxacademy.opal.kalendaryo.kalendaryo.controllers;

import com.greenfoxacademy.opal.kalendaryo.kalendaryo.model.entity.GoogleCalendarUpdate;
import com.greenfoxacademy.opal.kalendaryo.kalendaryo.service.GoogleCalendarUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.greenfoxacademy.opal.kalendaryo.kalendaryo.authorization.AuthorizeKal.authorize;

@RestController
@Profile("dev")
public class DevController {

    @Autowired
    GoogleCalendarUpdateService googleCalendarUpdateService;

    @GetMapping("/accesstoken")
    public String getAccessToken(@RequestParam String authCode) throws IOException {
        return authorize(authCode);
    }

    @GetMapping(value = "/notification")
    public Iterable<GoogleCalendarUpdate> showAllGoogleCalendarUpdate() {
        Iterable<GoogleCalendarUpdate> responses = googleCalendarUpdateService.findAllGoogleCalendarUpdate();
        System.out.println(responses);
        return responses;
    }
}
