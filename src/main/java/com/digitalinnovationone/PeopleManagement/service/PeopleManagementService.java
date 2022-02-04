package com.digitalinnovationone.PeopleManagement.service;

import com.digitalinnovationone.PeopleManagement.dto.request.PersonDTO;
import com.digitalinnovationone.PeopleManagement.dto.response.MessageResponseDTO;
import com.digitalinnovationone.PeopleManagement.entity.Person;
import com.digitalinnovationone.PeopleManagement.exceptions.PersonNotFoundException;
import com.digitalinnovationone.PeopleManagement.mapper.PeopleMapper;
import com.digitalinnovationone.PeopleManagement.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleManagementService {

    private PersonRepository personRepository;

    private final PeopleMapper peopleMapper = PeopleMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = peopleMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse("Created person with ID ", savedPerson.getId());
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople
                .stream()
                .map(peopleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO listById(Long id) throws PersonNotFoundException {
        Person person = verifyAndFindIfExists(id);
        return peopleMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyAndFindIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyAndFindIfExists(id);
        Person personToUpdate = peopleMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse("Updated person with ID ", id);
    }

    private Person verifyAndFindIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String message, Long id){
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
