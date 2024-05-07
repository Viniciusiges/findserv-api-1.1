package br.com.inteliset.findserv.dto.clientModel;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClientActive(@NotNull UUID id, Boolean active) {
}
