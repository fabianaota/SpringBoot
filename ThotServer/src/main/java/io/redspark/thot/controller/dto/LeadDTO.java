package io.redspark.thot.controller.dto;

import io.redspark.thot.enums.LeadStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeadDTO {

    private Long id;
    private String company;
    private String description;
    private UserDTO vendor;
    private LeadStatus leadStatus;

}
