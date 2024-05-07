package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.professional.Activity;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProfessionalUpdateData(@NotNull UUID id, String phone, Activity activity, String valueHour) {

}
