package br.com.inteliset.findserv.dto.addressModel;

import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.model.professional.Professional;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class AddressResponse {

    private String postalCode;
    private String state;
    private String city;
    private String district;
    private String street;
    private String number;
    private String complement;


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

}
