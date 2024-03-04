package org.example.model;
import org.springframework.hateoas.*;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Organization extends RepresentationModel<Organization> {
    @Id
    private String organizationId;
    private String organizationName;
    private String licenseId;
}
