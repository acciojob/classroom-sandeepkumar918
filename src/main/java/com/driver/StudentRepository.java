package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {
    private static HashMap<String, Student> studentDb;
    private static HashMap<String, Teacher> teacherDb;
    private static HashMap<String, List<String>> studentTeacherDb;

    public StudentRepository() {
        this.studentDb = new HashMap<String, Student>();
        this.teacherDb = new HashMap<String, Teacher>();
        this.studentTeacherDb = new HashMap<String, List<String>> ();
    }

    //Add student to Student database
    public static void addStudentToDb(Student student){
        studentDb.put(student.getName(),student);
    }

    //Add teacher to teacher database
    public static void addTeacherToDb(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
    }

    //Add student teacher pair to database
    public static void addStudentTeacherPairToDb(String student, String teacher){
        List<String> studentsList=new ArrayList<>();
        if(studentDb.containsKey(student) && teacherDb.containsKey(teacher)){

            if(studentTeacherDb.containsKey(teacher)){
                studentsList=studentTeacherDb.get(teacher);

            }
            studentsList.add(student);
            studentTeacherDb.put(teacher,studentsList);
        }
    }

    //Get Student by student name from database
    public static Student getStudentByNameFromDb(String name){

        Student student=null;
        if(studentDb.containsKey(name)){
            student=studentDb.get(name);
        }
        return student;
    }

    //Get Teacher by name from database
    public static Teacher getTeacherByNameFromDb(String name){
        Teacher teacher=null;
        if(teacherDb.containsKey(name)){
            teacher=teacherDb.get(name);
        }
        return teacher;
    }

    //Get Students from database by teacher name
    public static List<String> getStudentsByTeacherNameFromDb(String name){
        List<String> studentsList=new ArrayList<>();
        if(studentTeacherDb.containsKey(name)){
            studentsList=studentTeacherDb.get(name);
        }
        return studentsList;
    }

    //Get list of all Students added from database
    public static List<String> getAllStudentsAddedFromDb(){
        List<String> studentsList=new ArrayList<>();
        for(String student: studentDb.keySet()){
            studentsList.add(student);
        }
        return studentsList;
    }

    //Delete Teacher his and student by teacher name from database
    public static void deleteTeacherByNameFromDb(String teacherName){
        List<String> students=new ArrayList<>();
        if(studentTeacherDb.containsKey(teacherName)) {
            students=studentTeacherDb.get(teacherName);

            for(String student: students){
                if(studentDb.containsKey(student)){
                    studentDb.remove(student);
                }
            }
            studentTeacherDb.remove(teacherName);
        }
        if(teacherDb.containsKey(teacherName)){
            teacherDb.remove(teacherName);
        }
    }


    //Delete all teachers from database
    public static void deleteAllTeachersFromDb(){

        teacherDb=new HashMap<>();
        for(String teacher: studentTeacherDb.keySet()){
            List<String> students=new ArrayList<>();
            for(String studentName: studentTeacherDb.get(teacher)) {
                students.add(studentName);
            }
            for(String name: students){
                if(studentDb.containsKey(name)){
                    studentDb.remove(name);
                }
            }
        }
        studentTeacherDb=new HashMap<>();
    }

}
