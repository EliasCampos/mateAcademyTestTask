package academy.mate.elias.testTask;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import academy.mate.elias.testTask.exceptions.CalculatorInputException;

public class Main {
    /**
     * The program will let user makes
     * basic arithmetic operation above
     * two numbers.
	 *
     * @author Elias
     */

    private static Scanner userInput;
    private static String descriptionPath;

    static {
		userInput = new Scanner(System.in);
		descriptionPath = "/home/elias/IdeaProjects/mateacademy/test_task/description.txt";
	}

    public static void main(String[] args) {

    	Main.printDescription();

    	for (;;) Main.programLoop();

    }

    public static void printDescription() {
		try {
			BufferedReader file = new BufferedReader(new FileReader(Main.descriptionPath));
			String line;

			while ((line = file.readLine()) != null) {
				System.out.println(line);
			}

		} catch (java.io.FileNotFoundException e) {
			System.out.println("-- description is unavailable (Can't find description file) ... --");
		} catch (java.io.IOException e) {
			System.out.println("-- description is unavailable... --");
		}
	}

    public static void programLoop() {
    	try {
			// Read an expression from an user input:
			System.out.println("Input an arithmetic expression:");
			String expressionString = Main.userInput.nextLine();

			if (expressionString.equals("exit") || expressionString.equals("q")) System.exit(0);
			// Extract operands and operator type from there:
			ArithmeticExpression expression = new ArithmeticExpression(expressionString);

			int a = expression.getFirstOperand();
			int b = expression.getSecondOperand();
			AllowedOperators operatorType = expression.getOperatorType();

			// Calculate result and prepare string for output:
			String resultString = Calculator.prepareResultString(operatorType, a, b);
			// Write result in the output:
			System.out.println("Result: " + resultString);

		} catch(CalculatorInputException e) {
    		System.out.println("NO WAY!: " + e.getMessage());
		}
	}
}
