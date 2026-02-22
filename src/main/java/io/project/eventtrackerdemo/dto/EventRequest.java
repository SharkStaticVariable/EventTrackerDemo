package io.project.eventtrackerdemo.dto;

import jakarta.validation.constraints.NotBlank;

public record EventRequest (
    @NotBlank String userId,
    @NotBlank String type,
    String payload
) {}