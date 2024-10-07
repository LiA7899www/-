package com.example.studentmanagement01.service;

import com.example.studentmanagement01.model.Student;
import com.example.studentmanagement01.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Student registerStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    public Student loginByStudentId(Long studentId, String rawPassword) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null && passwordEncoder.matches(rawPassword, student.getPassword())) {
            return student;
        }
        return null;
    }

    public Student loginByPhone(String phoneNumber, String code) {
        // 验证码逻辑这里可以添加
        // 假设验证码验证通过
        return studentRepository.findByPhoneNumber(phoneNumber);
    }
    public boolean resetPassword(String phoneNumber, String code, String newPassword) {
        // 验证码逻辑，假设验证码验证成功
        Student student = studentRepository.findByPhoneNumber(phoneNumber);
        if (student != null) {
            student.setPassword(passwordEncoder.encode(newPassword));
            studentRepository.save(student);
            return true;
        }
        return false;
    }

}
