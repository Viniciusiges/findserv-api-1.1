package br.com.inteliset.findserv.mapper.client;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.dto.clientModel.ClientRequest;
import br.com.inteliset.findserv.dto.clientModel.ClientResponse;
import br.com.inteliset.findserv.dto.clientModel.ClientDetail;
import br.com.inteliset.findserv.dto.clientModel.ClientRequestUpdate;
import br.com.inteliset.findserv.exception.DomainException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientMapper {

    private final ModelMapper modelMapper;

    public ClientMapper (ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

public ClientResponse toModel (Client client){
    return modelMapper.map(client, ClientResponse.class);
}

    public Client toEntity (ClientRequest client){
        return modelMapper.map(client, Client.class);
    }


    public Client toEntityUpdate(ClientRequestUpdate clientRequestUpdate) {
        if (clientRequestUpdate == null) {
            throw new DomainException("Dados incorretos");
        }
        Client client = modelMapper.map(clientRequestUpdate, Client.class);
        if (clientRequestUpdate.getAddress() != null) {
            Address address = modelMapper.map(clientRequestUpdate.getAddress(), Address.class);
            client.setAddressId(address);
        }
        return client;
    }

    public List<ClientResponse> toCollectionModel(Page<Client> page) {
        List<Client> clients = page.getContent();
        return toCollectionModel(clients);
    }

    public List<ClientResponse> toCollectionModel(List<Client> clients) {
        return clients.stream()
                .map(this::toModel)
                .toList();
    }

    public ClientDetail toModelDetail (Client client){
        return modelMapper.map(client, ClientDetail.class);
    }

}
