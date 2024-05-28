package br.com.inteliset.findserv.dto.professionalModel;

import br.com.inteliset.findserv.domain.model.professional.Activity;
import br.com.inteliset.findserv.dto.addressModel.AddressRequest;

public class ProfessionalDetail{

    private String name;

    private String cpf;

    private String phone;

    private String email;
    private String beenWorking;
    private String valueHour;

    private Activity activity;
    private AddressRequest address;

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBeenWorking() {
        return beenWorking;
    }

    public String getValueHour() {
        return valueHour;
    }

    public Activity getActivity() {
        return activity;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBeenWorking(String beenWorking) {
        this.beenWorking = beenWorking;
    }

    public void setValueHour(String valueHour) {
        this.valueHour = valueHour;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }
}
