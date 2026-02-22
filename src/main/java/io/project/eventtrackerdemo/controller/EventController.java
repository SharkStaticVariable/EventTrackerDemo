package io.project.eventtrackerdemo.controller;

import io.project.eventtrackerdemo.dto.EventResponse;
import io.project.eventtrackerdemo.dto.EventRequest;
import io.project.eventtrackerdemo.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private EventService eventService;

    @PostMapping
    public EventResponse create(
            @RequestBody @Valid EventRequest request){
        return eventService.create(request);
    }

    @GetMapping("/{userId}")
    public List<EventResponse> getByUser(
            @PathVariable String userid){
        return eventService.findByUser(userid);
    }




}