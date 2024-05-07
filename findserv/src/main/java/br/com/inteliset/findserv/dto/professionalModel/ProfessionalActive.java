package br.com.inteliset.findserv.dto.professionalModel;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProfessionalActive(@NotNull UUID id, Boolean active) {
}
