package com.example.studentmanagement01.respository;

import com.example.studentmanagement01.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//创建学生存储库接口
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(long studentId); // 根据学号查找学生

    Student findByPhoneNumber(String phoneNumber);// 根据手机号查找学生
}
