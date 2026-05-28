package com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.repository;

import com.re.hcm_k24_cntt1_tranducanh_kiemtrathuchanhsession06.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
