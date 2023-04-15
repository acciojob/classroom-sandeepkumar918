package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //Add Student at Service Layer
    public static void addStudentAtService(Student student){
        StudentRepository.addStudentToDb(student);
    }

    //Add teacher at service layer
    public static void addTeacherAtService(Teacher teacher){
        StudentRepository.addTeacherToDb(teacher);
    }

    //Add student teacher pair at service layer
    public static void addStudentTeacherPair(String student, String teacher){

        StudentRepository.addStudentTeacherPairToDb(student,teacher);
    }

    //Get student by name at service layer
    public static Student getStudentByName(String name){

        Student student=StudentRepository.getStudentByNameFromDb(name);
        return student;
    }

    //get teacher by name at service layer
    public static Teacher getTeacherByName(String name){
        Teacher teacher= StudentRepository.getTeacherByNameFromDb(name);
        return teacher;
    }

    //get Students by teacher name
    public static List<String> getStudentsByTeacherName(String name){
        return StudentRepository.getStudentsByTeacherNameFromDb(name);
    }

    //get all student added at service layer
    public static List<String> getAllStudentAdded(){
        return StudentRepository.getAllStudentsAddedFromDb();
    }

    //Delete teacher and its students at service layer
    public static void deleteTeacherByName(String name){
        StudentRepository.deleteTeacherByNameFromDb(name);
    }

    //Delete All Teachers
    public static void deleteAllTeahers(){
        StudentRepository.deleteAllTeachersFromDb();
    }
}
