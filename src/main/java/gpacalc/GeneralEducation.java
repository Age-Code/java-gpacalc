package gpacalc;

public class GeneralEducation extends Course {
    public GeneralEducation() {
        super();
    }

    public GeneralEducation(String courseName, int credit, String grade) {
        super(courseName, credit, grade);
    }

    // input 받고 GeneralEducation 객체 리턴
    public static GeneralEducation createGE(String input) {
        String[] split = input.split("-");

        if(split.length != 3){
            throw new IllegalArgumentException("잘못된 과목정보입니다.");
        }

        return new GeneralEducation(split[0], Integer.parseInt(split[1]), split[2]);
    }

    @Override
    public String toString() {
        return "[교양] " + getCourseName() + "," + getCredit() + "," + getGrade();
    }
}
