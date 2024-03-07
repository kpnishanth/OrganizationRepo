package org.example.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.hateoas.*;

import lombok.Data;


@Entity
@Data

public class Organization extends RepresentationModel<Organization> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String organizationId;
    private String organizationName;
    private String licenseId;
}
