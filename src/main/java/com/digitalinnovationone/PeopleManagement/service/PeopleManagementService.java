package com.digitalinnovationone.PeopleManagement.service;

import com.digitalinnovationone.PeopleManagement.dto.request.PersonDTO;
import com.digitalinnovationone.PeopleManagement.dto.response.MessageResponseDTO;
import com.digitalinnovationone.PeopleManagement.entity.Person;
import com.digitalinnovationone.PeopleManagement.exceptions.PersonNotFoundException;
import com.digitalinnovationone.PeopleManagement.mapper.PeopleMapper;
import com.digitalinnovationone.PeopleManagement.repository.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;

public class PeopleManagementService {

    private PersonRepository personRepository;

    private final PeopleMapper peopleMapper = PeopleMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = peopleMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse("Created person with ID ", savedPerson.getId());
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String message, Long id){
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
