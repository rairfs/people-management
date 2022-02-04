package com.digitalinnovationone.PeopleManagement.controller;

import com.digitalinnovationone.PeopleManagement.dto.request.PersonDTO;
import com.digitalinnovationone.PeopleManagement.dto.response.MessageResponseDTO;
import com.digitalinnovationone.PeopleManagement.exceptions.PersonNotFoundException;
import com.digitalinnovationone.PeopleManagement.service.PeopleManagementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/management")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleManagementController {

    private PeopleManagementService peopleManagementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return peopleManagementService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAllPerson(){
        return peopleManagementService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable Long id) throws PersonNotFoundException {
        return peopleManagementService.listById(id);
    }

    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return peopleManagementService.updateById(id, personDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        peopleManagementService.delete(id);
    }
}
