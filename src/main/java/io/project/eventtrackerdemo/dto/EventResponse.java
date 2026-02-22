package io.project.eventtrackerdemo.dto;

import java.time.Instant;
import java.util.UUID;

public record EventResponse (
        UUID id,
        String userId,
        String type,
        String payload,
        Instant createdAt
) { }
