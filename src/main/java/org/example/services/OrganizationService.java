package org.example.services;

import org.example.model.Organization;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrganizationService {

    public Organization getOrganization(String licenseId){
        Organization organization = new Organization();
        organization.setId(1543L);
        organization.setOrganizationName("Intel");
        organization.setLicenseId("123");
        return organization;
    }

    public List<Organization> getAllOrganizations(){
        List<Organization> listOranization= new ArrayList<>();
        for ( int i=0;i<12;i++){
            Organization organization = new Organization();
            organization.setId(i+12L);
            organization.setOrganizationName("Intel"+i);
            organization.setLicenseId("123"+i+i);
            listOranization.add(organization);
        }
        return listOranization;
    }
}
