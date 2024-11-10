package com.sms.SMS.Repository;
import com.sms.SMS.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student, Long> {

}
