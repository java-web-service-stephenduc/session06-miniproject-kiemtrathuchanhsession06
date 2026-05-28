package com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String fullName;
    private String email;
    private Double gpa;
}
