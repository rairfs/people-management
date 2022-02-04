package com.digitalinnovationone.PeopleManagement.dto.request;

import com.digitalinnovationone.PeopleManagement.entity.Email;
import com.digitalinnovationone.PeopleManagement.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 150)
    private String name;

    @NotEmpty
    private String hireDate;

    private String resignationDate;

    @NotEmpty
    @CPF
    private String cpf;

    @Valid
    @NotEmpty
    private List<Phone> phoneList;

    @Valid
    private List<Email> emailList;
}
