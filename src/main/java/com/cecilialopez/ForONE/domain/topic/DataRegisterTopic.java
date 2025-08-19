package com.cecilialopez.ForONE.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long idUser,
        @NotBlank
        String course
) {
}
