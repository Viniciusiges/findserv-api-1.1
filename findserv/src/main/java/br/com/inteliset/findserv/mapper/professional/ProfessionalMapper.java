package br.com.inteliset.findserv.mapper.professional;

import br.com.inteliset.findserv.domain.model.professional.Professional;
import br.com.inteliset.findserv.dto.professionalModel.*;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessionalMapper {
        private final ModelMapper modelMapper;

    public ProfessionalMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProfessionalResponse toModel (Professional professional){
        return modelMapper.map(professional, ProfessionalResponse.class);
    }
    public Professional toEntity (ProfessionalRequest professional){
        return modelMapper.map(professional, Professional.class);
    }
    public Professional toEntityUpdate (ProfessionalRequestUpdate professional){
        return modelMapper.map(professional, Professional.class);
    }

    public List<ProfessionalResponse> toCollectionModel (Page<Professional> professional) {
        return professional.stream()
                .map(this::toModel)
                .toList();
    }


    public ProfessionalDetail toModelDetail(Professional professional) {
        return modelMapper.map(professional, ProfessionalDetail.class);
    }
}
