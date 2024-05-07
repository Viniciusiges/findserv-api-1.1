package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.domain.model.professional.Activity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ProfessionalRequest {

    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    private String beenWorking;
    private String valueHour;
    @NotNull
    private Activity activity;
    private Address address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBeenWorking() {
        return beenWorking;
    }

    public void setBeenWorking(String beenWorking) {
        this.beenWorking = beenWorking;
    }

    public String getValueHour() {
        return valueHour;
    }

    public void setValueHour(String valueHour) {
        this.valueHour = valueHour;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
