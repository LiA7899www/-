package com.example.studentmanagement01.controller;

import com.example.studentmanagement01.model.ResetPasswordRequest;
import com.example.studentmanagement01.model.Student;
import com.example.studentmanagement01.model.LoginRequest;
import com.example.studentmanagement01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 注册接口
    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        Student newStudent = studentService.registerStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    // 学号和密码登录接口
    @PostMapping("/login/studentId")
    public ResponseEntity<String> loginByStudentId(@RequestBody LoginRequest loginRequest) {
        Student student = studentService.loginByStudentId(loginRequest.getStudentId(), loginRequest.getPassword());
        if (student != null) {
            return ResponseEntity.ok("登录成功");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("无效的凭证");
    }

    // 手机号和验证码登录接口
    @PostMapping("/login/phone")
    public ResponseEntity<String> loginByPhone(@RequestBody LoginRequest loginRequest) {
        // 假设验证码验证逻辑在这里
        Student student = studentService.loginByPhone(loginRequest.getPhoneNumber(), loginRequest.getCode());
        if (student != null) {
            return ResponseEntity.ok("登录成功");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("无效的凭证");
    }
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest resetRequest) {
        boolean success = studentService.resetPassword(resetRequest.getPhoneNumber(), resetRequest.getCode(), resetRequest.getNewPassword());
        if (success) {
            return ResponseEntity.ok("密码重置成功");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("重置失败，检查信息");
    }
}
