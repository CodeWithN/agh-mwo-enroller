package com.company.enroller.controllers;


import com.company.enroller.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.enroller.model.Meeting;
import com.company.enroller.persistence.MeetingService;
import com.company.enroller.persistence.ParticipantService;

import java.util.Collection;


@RestController
@RequestMapping("/meeting")
public class MeetingRestController {

    @Autowired
    MeetingService meetingService;

    @Autowired
    ParticipantService participantService;

    //display meetings as a list
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getMeetings() {
        Collection<Meeting> meetings = meetingService.getAll();
        return new ResponseEntity<Collection<Meeting>>(meetings, HttpStatus.OK);
    }

    //Find one meeting by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMeetingById(@PathVariable("id") long id) {
        Meeting meeting = meetingService.findById(id);
        if (meeting == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Meeting>(meeting, HttpStatus.OK);
    }


    // POST - Adding the meeting
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewMeeting(@RequestBody Meeting meeting) {

        Meeting newMeeting = meetingService.addNewMeeting(meeting);
        return new ResponseEntity<Meeting>(newMeeting, HttpStatus.OK);
    }


}