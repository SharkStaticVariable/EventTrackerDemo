package io.project.eventtrackerdemo.repository;

import io.project.eventtrackerdemo.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {
    List<EventEntity> findByUserId(String userId);
}
