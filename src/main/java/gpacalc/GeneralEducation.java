package gpacalc;

public class GeneralEducation extends Course {
    public GeneralEducation() {
        super();
    }

    public GeneralEducation(Course course) {
        super(course.getCourseName(), course.getCredit(), course.getGrade());
    }

    // input 받고 GeneralEducation 객체 리턴
    public static GeneralEducation createGE(String input) {
        return new GeneralEducation(createCourse(input));
    }

    @Override
    public String toString() {
        return "[교양] " + getCourseName() + "," + getCredit() + "," + getGrade();
    }
}
