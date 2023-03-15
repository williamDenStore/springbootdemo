package com.example.springbootdemo.repository;

import com.example.springbootdemo.entity.Organization;
import com.example.springbootdemo.projection.OrgName;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrganizationRepository extends ListCrudRepository<Organization, Long> {
    @EntityGraph(value = "Organization.persons")
    List<Organization> findAll();

    @Query("from Organization o")
    List<OrgName> findNamesBy();
}
