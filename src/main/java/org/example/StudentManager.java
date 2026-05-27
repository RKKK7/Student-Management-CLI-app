package org.example;

import java.util.*;

public class StudentManager {

    private List<Student> students = new ArrayList<>();


    public boolean addNewStudent(int id, int age, String name, String course){
        if(findById(id)!=null){
            return false;
        }else {
            students.add(new Student(id, age, name, course));
            return true;
        }
    }

    public boolean removeStudentById(int id){
        Student s = findById(id);
        if(s!=null){
            students.remove(s);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateStudentName(int id, String name){
        Student s = findById(id);
        if(s != null){
            s.setName(name);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateStudentCourse(int id, String course){
        Student s = findById(id);
        if(s != null){
            s.setCourse(course);
            return true;
        }else{
            return false;
        }
    }

    public boolean getStudentInfo(int id){
        Student s = findById(id);
        if(s != null){
            System.out.println(" student ID: "+s.getId());
            System.out.println(" student Name: "+s.getName());
            System.out.println(" student Age: "+s.getAge());
            System.out.println(" student Course: "+s.getCourse());
            return true;
        }else{
            return false;
        }
    }

    public boolean getAllStudentInfo(){
        if(students.isEmpty()){
            return false;
        }else{
            for (Student s : students){
                System.out.println(" student ID: "+s.getId());
                System.out.println(" student Name: "+s.getName());
                System.out.println(" student Age: "+s.getAge());
                System.out.println(" student Course: "+s.getCourse());
                System.out.println("");
                System.out.println("------------------------");
                System.out.println("");
            }
            return true;
        }
    }

    private Student findById(int id) {
        for (Student s : students)
            if (s.getId() == id) return s;
        return null;
    }


}
