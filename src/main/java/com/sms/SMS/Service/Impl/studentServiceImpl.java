package com.sms.SMS.Service.Impl;
import com.sms.SMS.Model.Student;
import com.sms.SMS.Repository.studentRepository;
import com.sms.SMS.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpl  implements studentService {

    @Autowired
    private studentRepository studentRepository;
 
    //save student in database
    @Override
    public Student saveStudent(Student student){
    return studentRepository.save(student);
    }

    //get all students form database
    @Override
    public List<Student> getAllStudents() {
    return studentRepository.findAll();
    }

    //get student using id
    @Override
    public Student getStudentById(long id) {
    Optional<Student> student = studentRepository.findById(id);
    if(student.isPresent()){
    return student.get();
    }else {
    throw new RuntimeException();
    }
    }

    //update student
    @Override
    public Student updateStudent(Student student, long id) {
    Student existingStudent = studentRepository.findById(id).orElseThrow(
    ()-> new RuntimeException()
    );
 
    existingStudent.setFirstName(student.getFirstName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setEmail(student.getEmail());
 
    // save
    studentRepository.save(existingStudent);
    return existingStudent;
    }

    //delete student
    @Override
    public void deleteStudent(long id) {
 
    //check
    studentRepository.findById(id).orElseThrow(()-> new
    RuntimeException());
 
    //delete
    studentRepository.deleteById(id);
    }

    
}
