package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.professional.Activity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ProfessionalRegistrationData(
        @NotBlank //Não pode ser nulo nem em branco, so funciona com string.
        String name,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String phone,
        @NotBlank
        @Email
        String email,
        String beenWorking,
        String valueHour,
        @NotNull
        Activity activity)
//        @NotNull
//        @Valid //Dizendo que dentro desse DTO tem outras validações
//        DatasAddress address)
{
}
