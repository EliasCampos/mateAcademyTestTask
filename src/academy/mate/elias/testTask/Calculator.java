package academy.mate.elias.testTask;

public class Calculator {
    private static int add(int a, int b) { return a + b ;}
    private static int subtract(int a, int b) { return a - b ;}
    private static long multiply(int a, int b) { return ((long) a) * ((long) b) ;}
    private static float divide(int a, int b) { return ((float) a) / ((float) b) ;}

    public static String prepareResultString(AllowedOperators operator, int a, int b) {
        switch (operator) {
            case ADD: return String.valueOf(Calculator.add(a, b));
            case SUBTRACT: return String.valueOf(Calculator.subtract(a, b));
            case MULTIPLY: return String.valueOf(Calculator.multiply(a, b));
            case DIVIDE: return String.valueOf(Calculator.divide(a, b));
            default: throw new RuntimeException("Incorrect type of allowed operator has been transmitted in arguments");
        }
    }
}
