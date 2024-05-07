package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.address.Address;

import java.util.UUID;

public class ProfessionalUpdateRequest {

    private UUID id;
    private String phone;
    private Address address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
