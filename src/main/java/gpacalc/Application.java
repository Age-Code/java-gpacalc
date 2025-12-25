package gpacalc;

public class Application {
    public static void main(String[] args) {
        //TODO: 구현
        GpaCalculator calculator = new GpaCalculator();
        calculator.inputCourseList();
        System.out.print(calculator.toString());
    }
}
