package com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.service.impl;

import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.dto.StudentDTO;
import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.entity.Student;
import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.mapper.StudentMapper;
import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.repository.StudentRepository;
import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    public final StudentRepository studentRepository;
    public final StudentMapper studentMapper;

    //get all
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDTO)
                .toList();
    }

    //get by id
    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDTO)
                .orElse(null);
    }

    public StudentDTO createStudent(StudentDTO dto) {
        Student entity = studentMapper.toEntity(dto);
        Student saved = studentRepository.save(entity);
        return studentMapper.toDTO(saved);
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        return studentRepository.findById(id)
                .map(entity -> {
                    studentMapper.updateEntity(dto, entity);
                    Student saved = studentRepository.save(entity);
                    return studentMapper.toDTO(saved);
                })
                .orElse(null);
    }

    public StudentDTO patchStudent(Long id, StudentDTO dto) {
        return studentRepository.findById(id)
                .map(entity -> {
                    studentMapper.patchEntity(dto, entity);
                    Student saved = studentRepository.save(entity);
                    return studentMapper.toDTO(saved);
                })
                .orElse(null);
    }

    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
