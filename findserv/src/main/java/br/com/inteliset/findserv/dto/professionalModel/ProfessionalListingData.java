package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.professional.Activity;
import br.com.inteliset.findserv.domain.model.professional.Professional;

import java.util.UUID;

public record ProfessionalListingData(UUID id, String name, String phone, String email,
                                      String beenWorking, String valueHour, Activity activity ) {

    public ProfessionalListingData(Professional professional){
        this(professional.getId(), professional.getName(), professional.getPhone(), professional.getEmail(), professional.getBeenWorking(),
                professional.getValueHour(), professional.getActivity());
    }

}
