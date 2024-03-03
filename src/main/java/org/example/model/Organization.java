package org.example.model;
import org.springframework.hateoas.*;

import lombok.Data;

@Data
public class Organization extends RepresentationModel<Organization> {
    private String organizationId;
    private String organizationName;
    private String licenseId;
}
