package gpacalc;

public class Major extends Course{
    public Major() {
        super();
    }

    public Major(String courseName, int credit, String grade) {
        super(courseName, credit, grade);
    }

    // input 받고 Major 객체 리턴
    public static Major createMajor(String input) {
        String[] split = input.split("-");

        if(split.length != 3){
            throw new IllegalArgumentException("잘못된 과목정보입니다.");
        }

        return new Major(split[0], Integer.parseInt(split[1]), split[2]);
    }

    public String toString() {
        return "[전공] " + getCourseName() + "," + getCredit() + "," + getGrade();
    }
}
