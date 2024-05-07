package br.com.inteliset.findserv.mapper.address;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.dto.addressModel.AddressRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final ModelMapper modelMapper;

    public AddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Address toEntity (AddressRequest address){
        return modelMapper.map(address, Address.class);
    }


}
