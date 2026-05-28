package com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.mapper;

import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.dto.StudentDTO;
import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTO toDTO(Student entity) {
        if (entity == null) {
            return null;
        }
        return StudentDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .gpa(entity.getGpa())
                .build();
    }

    public Student toEntity(StudentDTO dto) {
        if (dto == null) {
            return null;
        }
        return Student.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .gpa(dto.getGpa())
                .build();
    }

    public void updateEntity(StudentDTO dto, Student entity) {
        if (dto == null || entity == null) {
            return;
        }
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setGpa(dto.getGpa());
    }

    public void patchEntity(StudentDTO dto, Student entity) {
        if (dto == null || entity == null) {
            return;
        }
        if (dto.getFullName() != null) {
            entity.setFullName(dto.getFullName());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getGpa() != null) {
            entity.setGpa(dto.getGpa());
        }
    }
}
