package br.com.inteliset.findserv.dto.professionalModel;

import java.util.UUID;

public class ProfessionalActive {

    private UUID id;
    private Boolean active;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
