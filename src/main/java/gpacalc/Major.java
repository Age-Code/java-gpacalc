package gpacalc;

public class Major extends Course{
    public Major() {
        super();
    }

    public Major(Course course) {
        super(course.getCourseName(), course.getCredit(), course.getGrade());
    }

    // input 받고 Major 객체 리턴
    public static Major createMajor(String input) {
        return new Major(createCourse(input));
    }

    public String toString() {
        return "[전공] " + getCourseName() + "," + getCredit() + "," + getGrade();
    }
}
