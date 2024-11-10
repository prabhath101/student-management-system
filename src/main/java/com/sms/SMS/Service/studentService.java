package com.sms.SMS.Service;
import com.sms.SMS.Model.Student;
import java.util.List;

public interface studentService {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id);
    void deleteStudent(long id);

}
