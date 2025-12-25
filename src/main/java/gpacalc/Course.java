package gpacalc;

public class Course {
    private String courseName; // 과목명
    private int credit; // 과목학점
    private String grade; // 과목성적
    private double gradeWeighting;

    public Course() {
        courseName = "";
        credit = 0;
        grade = "";
        gradeWeighting = 0.0;
    }

    public Course(String courseName, int credit, String grade) {
        this.courseName = courseName;
        this.credit = credit;
        this.grade = grade;
        this.gradeWeighting = calculateGradeWeighting();
    }

    // get & set start
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGradeWeighting() {
        return gradeWeighting;
    }
    public void setGradeWeighting(double gradeWeighting) {
        this.gradeWeighting = gradeWeighting;
    }
    // get & set end

    // String grade를 double Grade Point로 변환
    public double grade2GradePoint() {
        return switch (grade) {
            case "A+" -> 4.5;
            case "A0" -> 4.0;
            case "B+" -> 3.5;
            case "B0" -> 3.0;
            case "C+" -> 2.5;
            case "C0" -> 2.0;
            case "D+" -> 1.5;
            case "D0" -> 1.0;
            default -> 0;
        };
    }

    public double calculateGradeWeighting() {
        return grade2GradePoint()*credit;
    }

}
