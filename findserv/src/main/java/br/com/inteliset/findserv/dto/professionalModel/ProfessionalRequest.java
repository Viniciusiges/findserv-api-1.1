package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.domain.model.professional.Activity;
import br.com.inteliset.findserv.dto.addressModel.AddressRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

public class ProfessionalRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NumberFormat
    private String beenWorking;
    @NumberFormat
    private String valueHour;
    @NotNull
    @Enumerated
    private Activity activity;

    private Boolean active = true;
    @Valid
    @NotNull
    private AddressRequest address;

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

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
