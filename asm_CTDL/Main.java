package asm_CTDL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Student> studentlist = new ArrayList<>();

    public static void main(String args[]) {

        while (true) {
            System.out.println(
                    "\nMenu\n-_________- \n0: Student information \n1: Add Student \n2: Edit Student \n3: Delete Student \n4: Sort Student \n5: Search Student \n6: Exit \n-_________-");
            System.out.print("Enter your choice: ");
            int input = sc.nextInt();
    
            if (input == 0) {
                viewStudent();
            } else if (input == 1) {
                addStudent();
            } else if (input == 2) {
                editStudent();
            } else if (input == 3) {
                deleteStudent();
            } else if (input == 4) {
                sortStudent();
            } else if (input == 5) {
                searchStudent();
            } else if (input == 6) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
        }

    }

    public static void addStudent() {
        System.out.print("Enter number of student: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid integer value for the number of students: ");
            sc.next(); // Consume invalid input
        }
        int numStu = sc.nextInt();

        if (numStu <= 0) {
            System.out.print("Number of students must be greater than 0. Please enter a valid number: ");
            return; // Exit the method if the number of students is invalid
        }

        sc.nextLine();
        for (int i = 0; i < numStu; i++) {
            System.out.print("Enter Student Id: ");
            String studentId = sc.nextLine();

            boolean isDuplicated = studentlist.stream().anyMatch(student -> student.getStudentid().equals(studentId));
            if (isDuplicated) {
                System.out.print("Student ID already exists. Please enter a different ID.");
                i--;
                continue;
            }

            System.out.print("Enter Student name: ");
            String studentName = sc.nextLine();

            double studentMarks;
            while (true) {
                System.out.print("Enter Student Marks (0 - 10): ");

                if (sc.hasNextDouble()) {
                    studentMarks = sc.nextDouble();

                    if (studentMarks >= 0 && studentMarks <= 10) {
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid marks. Please enter a value between 0 and 10: ");
                    }

                } else {
                    System.out.println("Invalid marks. Please enter a valid value for marks.");
                    sc.next();
                }

            }
            Student student = new Student(studentId, studentName, studentMarks);
            studentlist.add(student);
        }
    }

    public static void deleteStudent() {
        viewStudent();
        sc.nextLine();
        System.out.print("Enter Student Id to delete: ");
        String studentId = sc.nextLine();

        for (Iterator<Student> iterator = studentlist.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.getStudentid().equals(studentId)) {
                iterator.remove();
                System.out.println("Student information deleted successfully.");
                break;
            } else {
                System.out.println("Student not found");
            }
        }
    }

    public static void sortStudent() {

        int n = studentlist.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (studentlist.get(j).getMarks() > studentlist.get(j + 1).getMarks()) {
                    Student temp = studentlist.get(j);
                    studentlist.set(j, studentlist.get(j + 1));
                    studentlist.set(j + 1, temp);
                    swapped = true;

                }
            }
            if (!swapped) {
                break;
            }
        }
        for (int i = 0; i < studentlist.size(); i++) {
            studentlist.get(i).setSudentRank(i + 1);
            studentlist.get(i).calRank();
        }

        System.out.println("Students sorted by marks:");
        for (Student student : studentlist) {
            System.out.println("Student ID: " + student.getStudentid() + ", Name: " + student.getName() + ", Marks: "
                    + student.getMarks() + ", Rank: " + student.getStudentRank());
        }
    }

    public static void searchStudent() {

        sc.nextLine();
        viewStudent();
          System.out.print("Enter Student Id to search: ");
        String studentId = sc.nextLine();

        boolean studentFound = false;
        for (Student student : studentlist) {
            if (student.getStudentid().equals(studentId)) {
                System.out.println("Student found:");
                System.out.println("Id: " + student.getStudentid() + "\nName: " + student.getName() + "\nMarks: "
                        + student.getMarks());
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student not found.");
        }
    }

    public static void editStudent() {

        viewStudent();
        sc.nextLine();
        System.out.print("Enter Student ID to edit: ");
        String studentId = sc.nextLine();

        for (Student student : studentlist) {
            if (student.getStudentid().equals(studentId)) {

                System.out.println("Current Student Id: " + student.getStudentid());
                System.out.println("Current Student Name: " + student.getName());     
                System.out.println("Current Student Marks: " + student.getMarks());

                System.out.print("Enter new name for the student: ");
                String newName = sc.nextLine();
                student.setName(newName);

                while (true) {
                    System.out.print("Enter new marks for the student: ");

                    if (sc.hasNextDouble()) {
                        double newMarks = sc.nextDouble();
                        student.setMarks(newMarks);
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid marks Please enter a valid value for marks");
                        //continue;
                    }
                }
                System.out.println("Student information updated successfully.");
                break;
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    public static void viewStudent() {

        System.out.println("Student List:");
        for (Student student : studentlist) {
            System.out.println("Student ID: " + student.getStudentid());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Marks: " + student.getMarks());
            student.calRank();
        }

    }

}
