package br.com.inteliset.findserv.dto.addressModel;

import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.model.professional.Professional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AddressRequest {

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "Não corresponde a um CEP valido")
    private String postalCode;
    @Pattern(regexp = "^[A-Z]{2}$", message = "Somente Letras Maiusculas")
    @NotBlank
    private String state;
    @NotBlank
    private String city;
    @NotBlank
    private String district;
    @NotBlank
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

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public Professional getProfessional() {
//        return professional;
//    }
//
//    public void setProfessional(Professional professional) {
//        this.professional = professional;
//    }
}
