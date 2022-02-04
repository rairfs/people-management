package com.digitalinnovationone.PeopleManagement.controller;

import com.digitalinnovationone.PeopleManagement.service.PeopleManagementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleManagementController {

    private PeopleManagementService peopleManagementService;


}
