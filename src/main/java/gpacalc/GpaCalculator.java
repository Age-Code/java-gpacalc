package gpacalc;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GpaCalculator {
    ArrayList<Course> courseList;

    public GpaCalculator() {
        courseList = new ArrayList<>();
    }

    // 전공 과목 입력받기
    public void inputMajor() {
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String input = Console.readLine();
        String[] majorList = input.split(",");
        for(String major : majorList){
            courseList.add(Major.createMajor(major));
        }
    }

    // 교양 과목 입력받기
    public void inputGE() {
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String input = Console.readLine();
        String[] GEList = input.split(",");
        for(String major : GEList){
            courseList.add(GeneralEducation.createGE(major));
        }
    }

    // 종합 입력받기
    public void inputCourseList() {
        inputMajor();
        System.out.println();
        inputGE();
        System.out.println();
    }

    public int validCredit(Course course, String condition1, String condition2) {
        if(!(course.getGrade().equals(condition1) || course.getGrade().equals(condition2))){
            return course.getCredit();
        }
        return 0;
    }

    // 취득학점 계산기
    public int calculateTC() {
        int totalCredits = 0;

        for(Course course : courseList){
            totalCredits += validCredit(course, "F", "NP");
            /*
            if(!(course.getGrade().equals("F") || course.getGrade().equals("NP"))){
                totalCredits += course.getCredit();
            }
             */
        }

        return totalCredits;
    }

    // 평점평균 계산기
    public double calculateGPA() {
        double gpa = 0.0;
        double gradeCredits = 0.0;

        for(Course course : courseList){
            gpa += course.getGradeWeighting();
            gradeCredits += validCredit(course, "P", "NP");
            /*
            if(!(course.getGrade().equals("P") || course.getGrade().equals("NP"))){
                gradeCredits += course.getCredit();
            }
             */
        }

        return gpa/gradeCredits;
    }

    // 전공 평점평균 계산기
    public double calculateMajorGPA() {
        double MajorGPA = 0.0;
        double gradeCredits = 0.0;

        for(Course course : courseList){
            if(course instanceof Major){
                MajorGPA += course.getGradeWeighting();
                gradeCredits += validCredit(course, "P", "NP");
                /*
                if(!(course.getGrade().equals("P") || course.getGrade().equals("NP"))){
                    gradeCredits += course.getCredit();
                }
                 */
            }
        }

        return MajorGPA/gradeCredits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<과목 목록>\n");
        for(Course course : courseList){
            sb.append(course.toString() + "\n");
        }

        sb.append("\n<취득학점>\n" + calculateTC() + "\n");
        sb.append("\n<평점평균>\n" + String.format("%.2f", calculateGPA()) + " / 4.5\n");
        sb.append("\n<전공 평점평균>\n" + String.format("%.2f", calculateMajorGPA()) + " / 4.5\n");

        return sb.toString();
    }
}
