package com.digitalinnovationone.PeopleManagement.dto.request;

import com.digitalinnovationone.PeopleManagement.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(value = EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 10, max = 11)
    private String number;
}
