package academy.mate.elias.testTask;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import academy.mate.elias.testTask.exceptions.CalculatorInputException;
import academy.mate.elias.testTask.numbers.AllowedNumber;
import academy.mate.elias.testTask.numbers.ArabicNumber;
import academy.mate.elias.testTask.numbers.RomanNumber;

public class ArithmeticExpression {
    /**
     * Represents expression, inputted by user.
     * Is responsible for expression validation and parsing.
     */
    private static String patternString;
    private static Pattern pattern;


    static {
        patternString = "^\\s*(\\d+|[IVX]+)\\s*([+\\-*/])\\s*(\\d+|[IVX]+)\\s*$";
        pattern = Pattern.compile(patternString);
    }

    // Methods for for converting parts of arithmetic xpression from string to it's object representation:
    private static AllowedNumber parseNumber(String numberString) {
        if (Pattern.matches("^\\d+$", numberString)) return new ArabicNumber(numberString);
        return new RomanNumber(numberString);
    }
    private static AllowedOperators parseOperator(char operatorChar) {
        switch (operatorChar) {
            case '+': return AllowedOperators.ADD;
            case '-': return AllowedOperators.SUBTRACT;
            case '*': return AllowedOperators.MULTIPLY;
            case '/': return AllowedOperators.DIVIDE;
            default: throw new CalculatorInputException("Unsupported operator.");
        }
    }

    private String expression;

    private AllowedNumber firstOperand;
    private AllowedNumber secondOperand;
    private AllowedOperators operatorType;

    public ArithmeticExpression(String expression) {
        this.expression = expression;

        this.validate();
        this.extractParts();
    }

    private void validate() {
        if (!Pattern.matches(ArithmeticExpression.patternString, this.expression)) {
            throw new CalculatorInputException("Invalid or unsupported expression.");
        }
    }
    private void extractParts() {
        Matcher theMatcher = ArithmeticExpression.pattern.matcher(this.expression);
        theMatcher.find();
        this.firstOperand = ArithmeticExpression.parseNumber(theMatcher.group(1));
        this.operatorType = ArithmeticExpression.parseOperator(theMatcher.group(2).charAt(0));
        this.secondOperand = ArithmeticExpression.parseNumber(theMatcher.group(3));

        if (firstOperand.getClass() != secondOperand.getClass()) {
            String msg = "Cannot execute operations between numbers in different numeral systems.";
            throw new CalculatorInputException(msg);
        }
    }

    public int getFirstOperand() {
        return this.firstOperand.toInteger();
    }
    public int getSecondOperand() {
        return this.secondOperand.toInteger();
    }
    public AllowedOperators getOperatorType() {
        return this.operatorType;
    }
}
