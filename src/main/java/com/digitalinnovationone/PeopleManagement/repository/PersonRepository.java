package com.digitalinnovationone.PeopleManagement.repository;

import com.digitalinnovationone.PeopleManagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
