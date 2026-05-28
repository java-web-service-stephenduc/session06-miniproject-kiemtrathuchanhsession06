package com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.service;

import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO createStudent(StudentDTO dto);

    StudentDTO updateStudent(Long id, StudentDTO dto);

    StudentDTO patchStudent(Long id, StudentDTO dto);

    boolean deleteStudent(Long id);
}
