package org.example.controller;

import org.example.model.Organization;
import org.example.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @GetMapping("/{licenseId}")
    public Organization getOrganization(@PathVariable("licenseId") String licenseId){
        Organization organization = organizationService.getOrganization(licenseId);
        Link link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrganizationController.class).getOrganization(licenseId)).withSelfRel();
        Link link2= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrganizationController.class).generateOraganizations()).withRel("all organizations");
        organization.add(link,link2);
        return organization;
    }




    @GetMapping(value = "/organizations", produces = "application/hal+json")
    public CollectionModel<Organization> generateOraganizations(){
        List<Organization> allOrganizations = organizationService.getAllOrganizations();
        Link link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrganizationController.class).generateOraganizations()).withSelfRel();
        CollectionModel<Organization> organizationCollectionModel = CollectionModel.of(allOrganizations).add(link);
        return organizationCollectionModel;
    }
}
