package io.project.eventtrackerdemo.mapper;

import io.project.eventtrackerdemo.dto.EventResponse;
import io.project.eventtrackerdemo.dto.EventRequest;
import io.project.eventtrackerdemo.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class EventMapper {
    public EventEntity toEntity(EventRequest request){
        return EventEntity.builder()
                .userid(request.userId())
                .type(request.type())
                .createdAt(Instant.now())
                .payload(request.payload())
                .build();
    }

    public EventResponse toResponse(EventEntity entity){
        return new EventResponse(
                entity.getId(),
                entity.getUserid(),
                entity.getType(),
                entity.getPayload(),
                entity.getCreatedAt()
        );
    }
}
