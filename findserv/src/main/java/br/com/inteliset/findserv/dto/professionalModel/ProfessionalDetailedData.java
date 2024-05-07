package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.domain.model.professional.Activity;
import br.com.inteliset.findserv.domain.model.professional.Professional;

import java.util.UUID;

public record ProfessionalDetailedData(UUID id, String name, String phone, String email,
                                       String beenWorking, String valueHour, Activity activity, Address address) {

    public ProfessionalDetailedData(Professional professional) {

        this(professional.getId(), professional.getName(), professional.getPhone(), professional.getEmail(), professional.getBeenWorking(),
                professional.getValueHour(), professional.getActivity(), professional.getAddress());
    }

}
