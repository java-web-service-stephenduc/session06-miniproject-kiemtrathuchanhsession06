package com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.controller;

import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.dto.StudentDTO;
import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.reponse.ApiResponse;
import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentDTO>>> getAll() {
        return ResponseEntity.ok(ApiResponse.response("Get all students", studentService.getAllStudents()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> getById(@PathVariable Long id) {
        StudentDTO dto = studentService.getStudentById(id);
        if (dto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.response("Student not found", null));
        }
        return ResponseEntity.ok(ApiResponse.response("Get student by id", dto));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentDTO>> create(@RequestBody StudentDTO dto) {
        StudentDTO created = studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.response("Student created", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        StudentDTO updated = studentService.updateStudent(id, dto);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.response("Student not found", null));
        }
        return ResponseEntity.ok(ApiResponse.response("Student updated", updated));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> patch(@PathVariable Long id, @RequestBody StudentDTO dto) {
        StudentDTO updated = studentService.patchStudent(id, dto);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.response("Student not found", null));
        }
        return ResponseEntity.ok(ApiResponse.response("Student patched", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.response("Student not found", null));
        }
        return ResponseEntity.ok(ApiResponse.response("Student deleted", null));
    }
}
