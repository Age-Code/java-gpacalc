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

    // 과목성적가중치 계산기
    public double calculateGradeWeighting() {
        return grade2GradePoint()*credit;
    }

    // 성적 입력 유효성 확인
    public static boolean validGrade(String grade) {
        return switch (grade) {
            case "A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P", "NP" -> true;
            default -> throw new IllegalArgumentException("잘못된 성적 입력입니다.");
        };
    }

    // 학점 입력 유효성 확인
    public static boolean validCredit(String credit) {
        return switch (credit) {
            case "1", "2", "3", "4" -> true;
            default -> throw new IllegalArgumentException("잘못된 학점 입력입니다.");
        };
    }

    // Course 생성기
    public static Course createCourse(String input) {
        String[] split = input.split("-");

        if(!(split.length == 3 && validCredit(split[1]) && validGrade(split[2]))) {
            throw new IllegalArgumentException("잘못된 과목정보입니다.");
        }

        return new Course(split[0], Integer.parseInt(split[1]), split[2]);
    }

}
