package com.driver;
import com.driver.Student;
import com.driver.StudentService;
import com.driver.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    //Add student
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){

        StudentService.addStudentAtService(student);

        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }

    //Add Teacher
    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){

        StudentService.addTeacherAtService(teacher);

        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }

    //add Student teacher pair
    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam("student") String student, @RequestParam("teacher") String teacher){

        StudentService.addStudentTeacherPair(student,teacher);

        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    //Get student by student name
    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable() String name){

        Student student = StudentService.getStudentByName(name); // Assign student by calling service layer method

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Get teacher by name
    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = StudentService.getTeacherByName(name); // Assign student by calling service layer method

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    //get all students by teacher name
    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = StudentService.getStudentsByTeacherName(teacher); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    //get all students
    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = StudentService.getAllStudentAdded(); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    //Delete teacher by name
    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam("teacher") String teacher){

        StudentService.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }

    //Delete all teachers
    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){

        StudentService.deleteAllTeahers();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }
}