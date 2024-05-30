package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.professional.Activity;
import br.com.inteliset.findserv.dto.addressModel.AddressRequestUpdate;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;

public class ProfessionalRequestUpdate {

    @Positive
    @Pattern(regexp = "\\d{11}", message = "Numero de telefone não corresponde a um numero valido")
    private String phone;
    @Valid
    private AddressRequestUpdate address;
    @NumberFormat
    private String beenWorking;
    @NumberFormat
    private String valueHour;
    @Enumerated
    private Activity activity;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressRequestUpdate getAddress() {
        return address;
    }

    public void setAddress(AddressRequestUpdate address) {
        this.address = address;
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
}
