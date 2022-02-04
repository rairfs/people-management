package com.digitalinnovationone.PeopleManagement.mapper;

import com.digitalinnovationone.PeopleManagement.dto.request.PersonDTO;
import com.digitalinnovationone.PeopleManagement.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    @Mapping(target = "hireDate", source = "hireDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "resignationDate", source = "resignationDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
