package io.project.eventtrackerdemo.service;

import io.project.eventtrackerdemo.dto.EventResponse;
import io.project.eventtrackerdemo.dto.EventRequest;
import io.project.eventtrackerdemo.entity.EventEntity;
import io.project.eventtrackerdemo.mapper.EventMapper;
import io.project.eventtrackerdemo.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Transactional
    public EventResponse create(EventRequest request){
         EventEntity entity = eventMapper.toEntity(request);
         eventRepository.save(entity);
         return eventMapper.toResponse(entity);
    }

    public List<EventResponse> findByUser(String userid){
        return eventRepository.findByUserId(userid)
                .stream()
                .map(eventMapper::toResponse)
                .toList();
    }
}