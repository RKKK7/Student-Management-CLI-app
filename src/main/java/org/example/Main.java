package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentManager manager = new StudentManager();
    public static void main(String[] args) {

        while (true){
            printChoices();
            int option = sc.nextInt();
            sc.nextLine();
            if(option==1){
                addStudent();
            }
            else if(option==2){
                removeStudent();
            }
            else if(option==3){
                updateStudent();
            }
            else if(option==4){
                getStudent();
            }
            else if(option==5){
                getAllStudent();
            }
            else if(option==6){
                System.out.println("Thank you for using Student Management CLI!!");
                break;
            }
        }

    }
    static void printChoices(){
        System.out.println("=====================================================");
        System.out.println("           WELCOME STUDENT MANAGEMENT CLI ");
        System.out.println("=====================================================");
        System.out.println("1. Add a student");
        System.out.println("2. remove a student");
        System.out.println("3. Update student details");
        System.out.println("4. Get a student details");
        System.out.println("5. Get all student details");
        System.out.println("6. Exit");
    }
    static void addStudent(){
        System.out.println(" Enter Student Id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(" Enter Student age");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println(" Enter Student name");
        String name = sc.nextLine();

        System.out.println(" Enter Student course");
        String course = sc.nextLine();

        if(manager.addNewStudent(id,age,name,course)){
            System.out.println("student added successfully");
            System.out.println("=====================================================");
        }else{
            System.out.println("student with ID "+id+" already exists");
            System.out.println("=====================================================");
        }
    }
    static void removeStudent(){
        System.out.println("Enter the ID of the student you wish to remove");
        int id = sc.nextInt();
        sc.nextLine();

        if(manager.removeStudentById(id)){
            System.out.println("Student removed successfully");
            System.out.println("=====================================================");
        }else{
            System.out.println("Student with ID "+id+" doesnt exist");
            System.out.println("=====================================================");
        }
    }
    static void updateStudent(){
        System.out.println("what would you like to update?");

        System.out.println("1. Name");
        System.out.println(("2. course"));
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice==1){
            System.out.println(" Enter the id of the student");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println(" Enter the name ");
            String name = sc.nextLine();
            if(manager.updateStudentName(id,name)){
                System.out.println("Student with ID "+id+" updated successfully");
                System.out.println("=====================================================");
            }else{
                System.out.println("Student with ID "+id+" doesnt exist");
                System.out.println("=====================================================");
            }
        }
        else if (choice==2){
            System.out.println(" Enter the id of the student");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println(" Enter the course ");
            String course = sc.nextLine();
            if(manager.updateStudentCourse(id,course)){
                System.out.println("Student with ID "+id+" updated successfully");
                System.out.println("=====================================================");
            }else{
                System.out.println("Student with ID "+id+" doesnt exist");
                System.out.println("=====================================================");
            }
        }
        else{
            System.out.println("Enter a valid option");
        }
    }
    static void getStudent(){
        System.out.println(" Enter the id of the student");
        int id= sc.nextInt();
        sc.nextLine();

        if(manager.getStudentInfo(id)){
            System.out.println(" student details of iD "+id+" fetched successfully");
            System.out.println("=====================================================");
        }else{
            System.out.println("Student with ID "+id+" doesnt exist");
            System.out.println("=====================================================");
        }
    }
    static void getAllStudent(){
        if(manager.getAllStudentInfo()){
            System.out.println(" All student details fetched successfully");
            System.out.println("=====================================================");
        }else{
            System.out.println("No students found");
            System.out.println("=====================================================");
        }
    }
}