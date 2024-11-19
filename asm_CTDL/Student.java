package asm_CTDL;

public class Student {
    private String studentName;
    private double studentMarks;
    private String studentId;
    private String studentRank;

    // constructor
    public Student(String studentId, String studentName, double studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;

    }

    // getter and setter
    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return studentMarks;
    }

    public void setMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }

    public String getStudentid() {
        return studentId;
    }

    public void setStudentid(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentRank() {
        return studentRank;
    }

    public void setSudentRank(int studentRank) {
        this.studentRank = String.valueOf(studentRank);
    }

    public void calRank() {
        if (studentMarks >= 0 && studentMarks < 5) {
            System.out.println("Rank: Fail");
            studentRank = "Fail";
        } else if (studentMarks >= 5 && studentMarks < 6.5) {
            System.out.println("Rank: Medium");
            studentRank = "Medium";
        } else if (studentMarks >= 6.5 && studentMarks < 7.5) {
            System.out.println("Rank: Good");
            studentRank = "Good";
        } else if (studentMarks >= 7.5 && studentMarks < 9.0) {
            System.out.println("Rank: Very good");
            studentRank = "Very good";
        } else {
            System.out.println("Rank: Excellent");
            studentRank = "Excellent";
        }

    }

}
